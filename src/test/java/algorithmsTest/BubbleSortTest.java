package algorithmsTest;

import algorithms.BubbleSort;
import org.junit.Test;

/**
 * @author iceper
 * @since 2017.02.25 03:21
 */
public class BubbleSortTest {
    @Test
    public void bubbleSort(){
        int a[] = {33,4,21,35,33,22,44,1,7,9,5};
        BubbleSort bubbleSort =
                new BubbleSort();
        bubbleSort.a(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
