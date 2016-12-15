package algorithms;


import java.util.HashMap;
import java.util.Map;

/**
 * @author iceper
 * @since 2016.12.15
 * 原题地址：https://leetcode.com/problems/lfu-cache/
 * 采用hashMap value 是个node数据结构，node里面包括缓存value值，访问次数、访问时间
 * 通过对node里数据的比较操作进行lfu算法。 当内存空间不够时，效率极低。
 */
public class LFUCache {

    int capacity;
    HashMap<Object, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Object, Node>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        node.increaseCount();
        return (Integer) cache.get(key).getData(System.nanoTime());
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.increaseCount();
            node.setData(value, System.nanoTime());
        } else {
            if (cache.size() >= capacity) {
                removeOld();
            }
            node = new Node(1, System.nanoTime(), value);
            cache.put(key, node);
        }
        return;
    }

    public void removeOld() {
        int removeCount = Integer.MAX_VALUE;
        long lastAccessTime = 0;
        Object removeKey = null;
        for (Map.Entry<Object, Node> entry : cache.entrySet()) {
            if (entry.getValue().getCount() <= removeCount) {
                if (entry.getValue().getCount() == removeCount) {
                    if (entry.getValue().getLastAccessTime() > lastAccessTime) {
                        continue;
                    }
                }
                removeCount = entry.getValue().getCount();
                lastAccessTime = entry.getValue().getLastAccessTime();
                removeKey = entry.getKey();
            }
        }
        cache.remove(removeKey);
    }

    class Node {
        private int count;
        private long lastAccessTime;
        private Object data;

        public Node(int count, long lastAccessTime, Object data){
            this.count = count;
            this.lastAccessTime = lastAccessTime;
            this.data = data;
        }

        public void increaseCount() {
            this.count ++ ;
        }

        public Object getData(long lastAccessTime) {
            this.lastAccessTime = lastAccessTime;
            return data;
        }

        public void setData(Object data, long lastAccessTime) {
            this.data = data;
            this.lastAccessTime = lastAccessTime;
        }

        public int getCount() {
            return count;
        }

        public long getLastAccessTime() {
            return lastAccessTime;
        }
    }
}
