package algorithmsTest;

import algorithms.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author iceper
 * @since 2017.02.22 00:08
 */
public class BinarySearchTest {
    @Test
    public void binarySearchTest(){
        BinarySearch binarySearch = new
                BinarySearch();
        int[] search ={1,3,4,5,6};
        int start = 0;
        int end = search.length;
        int key1 = 3;
        Assert.assertTrue(1 == binarySearch.binarySearch(search, start, end, key1));
        int key2 = 4;
        Assert.assertTrue(2 == binarySearch.binarySearch(search, start, end, key2));
        int key3 = 5;
        Assert.assertTrue(3 == binarySearch.binarySearch(search, start, end, key3));
        int key4 = 7;
        Assert.assertTrue(-1 == binarySearch.binarySearch(search, start, end, key4));
        int key5 = 1;
        Assert.assertTrue(0 == binarySearch.binarySearch(search, start, end, key5));
    }
}
