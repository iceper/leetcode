package algorithmsTest;

import algorithms.LRUCache;
import org.junit.Assert;
import org.junit.Test;

/**
 * LRUCache算法测试类.
 *
 * @author iceper
 * @since 2016/12/15 15:27
 */
public class LRUCacheTest {

    @Test
    public void lruCache1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(1) == 1);
        lruCache.printToTail(lruCache.getHead());
        lruCache.set(3, 3);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(3) == 3);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(2) == -1);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(1) == 1);
        lruCache.printToTail(lruCache.getHead());
    }

    @Test
    public void lruCache2(){
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(4) == 4);
        Assert.assertTrue(lruCache.get(3) == 3);
        Assert.assertTrue(lruCache.get(2) == 2);
        Assert.assertTrue(lruCache.get(1) == -1);
        lruCache.printToTail(lruCache.getHead());
        lruCache.set(5, 5);
        lruCache.printToTail(lruCache.getHead());
        Assert.assertTrue(lruCache.get(1) == -1);
        Assert.assertTrue(lruCache.get(2) == 2);
        Assert.assertTrue(lruCache.get(3) == 3);
        Assert.assertTrue(lruCache.get(4) == -1);
        Assert.assertTrue(lruCache.get(5) == 5);

    }
}
