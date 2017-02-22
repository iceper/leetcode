package algorithmsTest;

import algorithms.QuickSort;
import org.junit.Test;

/**
 * @author iceper
 * @since 2017.02.22 13:51
 */
public class QuickSortTest {
    @Test
    public void quickSortTest(){
        int a[] = {32,44,3,5,88,25,12,44};
        QuickSort quickSort = new
                QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
