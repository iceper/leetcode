package algorithms;

import java.util.HashMap;

/**
 * LRUCache缓存淘汰算法.
 * Leetcode题目地址：https://leetcode.com/problems/lru-cache/
 * @author fu tao
 * @since 2016/12/15 13:20
 */
public class LRUCache {
    private int currentSize = 0;
    private int capacity;
    /**
     * 缓存容器
     */
    private HashMap<Integer, Node> cache;
    /**
     * 链表的头
     */
    private Node head;
    /**
     * 链表的尾
     */
    private Node tail;

    public Node getHead() {
        return head;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            toHead(node);
            return node.value.intValue();
        }else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            toHead(node);
        }else {
            if (currentSize >= capacity) {
                removeOldCache(tail.key);
                removeTailNode();
            }
            Node node1 = new Node(key, value);
            cache.put(key, node1);
            toHead(node1);
            currentSize ++ ;
        }
        return;
    }

    /**
     * 打印链表中某一个节点到其尾部的所有节点信息
     * @param node 开始节点
     * @return
     */
    public void printToTail(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("key = " + node.key + " , value = " + node.value + "\t");
        printToTail(node.next);
    }

    /**
     * 双向链表，最近被访问的缓存key会放到链表头
     */
    class Node {
        Node pre;
        Node next;
        /**
         * 缓存的key
         */
        Integer key;
        /**
         * 缓存的value
         */
        Integer value;
        public Node (Integer key, Integer value) {
            this.key = key;
            this.value =value;
            pre = null;
            next = null;
        }
    }

    /**
     * 把节点放到链头
     * @param node
     */
    public void toHead(Node node) {
        if (currentSize == 0) {
            head = node;
            tail = node;
            return;
        }
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.pre;
            node.pre.next = null;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
            return;
        }
        if (node.pre !=null && node.next != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
            return;
        }
        if (node.pre == null && node.next == null) {
            node.next = head;
            head.pre = node;
            head = node;
            return;
        }
    }

    /**
     * 删除链表里尾节点
     */
    public void removeTailNode() {
        if (tail == null)
            return;
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail.pre.next = null;
        tail = tail.pre;
        return;
    }

    public void removeOldCache(Integer key) {
        cache.remove(key);
        currentSize--;
    }
}
