package algorithms;

import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author iceper
 * @since 2017.02.25 03:02
 * 冒泡排序 ：每一次外层循环，都能把最小的值通过两两比较放到最前面
 */
public class BubbleSort {
    public void a(int []b){
        for (int i = 0; i < b.length; i++) {
            for (int j = b.length - 1; j > i ; j--) {
                if (b[j] < b[j - 1]) {
                    int swap = b[j];
                    b[j] = b[j - 1];
                    b[j - 1] = swap;
                }
            }
        }
    }
}

