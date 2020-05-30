package sort;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description:
 **/
public class TestData {

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }

    public static int[] SORTED_DATA = new int[] {1,2,3,4,5,5,6,7};

    public static int[] REVERSE_SORTED_DATA = new int[] {7,6,5,5,4,3,2,1};

    public static int[] RANDOM_DATA = new int[] {1,3,4,2,5,6,5,7};

    public static void main(String[] args) {
        System.out.println("1. bubble sort");
        BubbleSort.bubbleSort(SORTED_DATA);
        BubbleSort.bubbleSort(REVERSE_SORTED_DATA);
        BubbleSort.bubbleSort(RANDOM_DATA);

        System.out.println("2. quick sort");
        QuickSort.quickSort(SORTED_DATA, 0, SORTED_DATA.length - 1);
        QuickSort.quickSort(REVERSE_SORTED_DATA, 0, SORTED_DATA.length - 1);
        QuickSort.quickSort(RANDOM_DATA, 0, SORTED_DATA.length - 1);

        System.out.println("3. insert sort");
        InsertSort.insertSort(SORTED_DATA);
        InsertSort.insertSort(REVERSE_SORTED_DATA);
        InsertSort.insertSort(RANDOM_DATA);

        System.out.println("4. shell sort");
        ShellSort.shellSort(SORTED_DATA);
        ShellSort.shellSort(REVERSE_SORTED_DATA);
        ShellSort.shellSort(RANDOM_DATA);

        System.out.println("5. select sort");
        SelectSort.selectSort(SORTED_DATA);
        SelectSort.selectSort(REVERSE_SORTED_DATA);
        SelectSort.selectSort(RANDOM_DATA);

        System.out.println("6. heap sort");
        HeapSort.heapSort(SORTED_DATA, true);
        HeapSort.heapSort(REVERSE_SORTED_DATA, true);
        HeapSort.heapSort(RANDOM_DATA, true);
        HeapSort.heapSort(SORTED_DATA, false);
        HeapSort.heapSort(REVERSE_SORTED_DATA, false);
        HeapSort.heapSort(RANDOM_DATA, false);

        System.out.println("7. merge sort");
        MergeSort.mergeSortRecurse(SORTED_DATA, 0, SORTED_DATA.length - 1);
        MergeSort.mergeSortRecurse(REVERSE_SORTED_DATA, 0, REVERSE_SORTED_DATA.length - 1);
        MergeSort.mergeSortRecurse(RANDOM_DATA, 0, RANDOM_DATA.length - 1);

        MergeSort.mergeSort(SORTED_DATA);
        MergeSort.mergeSort(REVERSE_SORTED_DATA);
        MergeSort.mergeSort(RANDOM_DATA);
    }
}
