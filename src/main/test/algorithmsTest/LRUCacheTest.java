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
    public void lrucache() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        Assert.assertTrue(lruCache.get(1) == 1);
        lruCache.set(3, 3);
        Assert.assertTrue(lruCache.get(3) == 3);
        Assert.assertTrue(lruCache.get(2) == -1);
        Assert.assertTrue(lruCache.get(1) == 1);
    }
}
