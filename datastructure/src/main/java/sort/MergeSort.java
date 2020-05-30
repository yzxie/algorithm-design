package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description: 合并排序
 * https://cloud.tencent.com/developer/article/1496531
 **/
public class MergeSort {

    public static void mergeSortRecurse(int[] nums, int low, int high) {

        // 分治算法：递归分解为两个子数组，在子数组内排序，然后再对两个子数组进行合并
        int mid = low + (high - low) / 2;

        // 当存在两个或两个以上元素时
        if (low < high) {
            // 左半边归并排序
            mergeSortRecurse(nums, low, mid);

            // 右半边归并排序
            mergeSortRecurse(nums, mid + 1, high);

            // 合并
            merge(nums, low, mid, high);

            // 打印
            if (low == 0 && high == nums.length - 1) {
                TestData.printArray(nums);
            }
        }
    }

    // 合并两个有序数组，第一个数组开始下标为low，结束下标为mid
    // 第二个数组开始下标为mid+1，结束下标为high
    private static void merge(int[] nums, int low, int mid, int high) {

        // 临时数组存放合并结果
        int[] tempArr = new int[high - low + 1];
        int tempIndex = 0;

        int left = low;
        int right = mid + 1;

        // 比较两个有序数组，从左到右合并
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                tempArr[tempIndex++] = nums[left++];
            } else {
                tempArr[tempIndex++] = nums[right++];
            }
        }

        while (left <= mid) {
            tempArr[tempIndex++] = nums[left++];
        }

        while (right <= high) {
            tempArr[tempIndex++] = nums[right++];
        }

        // 将合并后的有序数组赋值给原来的数组
        for (int i = 0; i < tempIndex; i++) {
            nums[low++] = tempArr[i];
        }
    }

    /**
     * 非递归解法
     *
     * @param list
     */
    public static void mergeSort(int[] list) {

        // gap的递增顺序为1，2，3，4...直到数组长度
        for (int gap = 1; gap < list.length; gap = 2 * gap) {
            mergeSortFromBottom(list, gap, list.length);
        }

        TestData.printArray(list);
    }

    private  static void mergeSortFromBottom(int[] array, int gap, int length) {
        int low = 0;

        // 归并gap长度的两个相邻子表，每次循环为执行两个不同的子数组合并
        // 如gap为2时，[0,1]与[2,3] -> low为0，mid为0+2-1为1，high为0+2*2-1为3，[4,5]与[6,7]

        for (low = 0; low + 2 * gap - 1 < length; low = low + 2 * gap) {
            merge(array, low, low + gap - 1, low + 2 * gap - 1);
        }

        // 余下两个子表，后者长度小于gap
        if (low + gap - 1 < length) {
            merge(array, low, low + gap - 1, length - 1);
        }
    }
}
