package algorithms;

/**
 * @author iceper
 * @since 2017.02.21 11.49
 * 二分查找算法
 * 一次能排除掉一半，所以算法复杂度为O(log2N)
 */
public class BinarySearch {
    public int binarySearch(int[] search, int start, int end, int key){
        if (start >= end)
            return -1;
        int mid = (start + end) / 2;
        int temp = search[mid];
        if (temp == key)
            return mid;
        else {
            if (temp > key) {
                return binarySearch(search, start, end - 1, key);
            }else {
                start = mid;
                return binarySearch(search, start + 1, end, key);
            }
        }
    }
}
