package algorithmsTest;

import algorithms.LFUCache;
import org.junit.Assert;
import org.junit.Test;

/**
 * LFUCache算法测试类.
 *
 * @author iceper
 * @since 2016/12/14 16:36
 */
public class LFUCacheTest {

    @Test
    public void lfucache() {

        LFUCache lfuCache = new LFUCache(0);
        lfuCache.set(0 ,0);
        Assert.assertTrue(lfuCache.get(0) == -1);

        LFUCache lfuCacheOtherUser =
                new LFUCache(2);
        lfuCacheOtherUser.set(1, 1);
        lfuCacheOtherUser.set(2, 2);
        Assert.assertTrue(lfuCacheOtherUser.get(1) == 1);
        lfuCacheOtherUser.set(3, 3);
        Assert.assertTrue(lfuCacheOtherUser.get(2) == -1);
        Assert.assertTrue(lfuCacheOtherUser.get(3) == 3);
        lfuCacheOtherUser.set(4, 4);
        Assert.assertTrue(lfuCacheOtherUser.get(1) == 1);
        Assert.assertTrue(lfuCacheOtherUser.get(3) == -1);
        Assert.assertTrue(lfuCacheOtherUser.get(4) == 4);
    }
}
