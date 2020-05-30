package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description: 快速排序
 **/
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {

        // 递归终止条件：只有一个元素时
        if (low < high) {

            // 每次取一个基准元素来讲数组分为两半，其中左边为小于或等于该元素，右边为大于该元素，
            // 然后继续在左边和右边重复该过程直到每个小区间的长度为1
            int mid = partition(nums, low, high);

            // 左半边排序
            quickSort(nums, low, mid - 1);

            // 右半边排序
            quickSort(nums, mid + 1, high);

            // 递归的最顶层才打印
            if (low == 0 && high == nums.length - 1) {
                TestData.printArray(nums);
            }
        }
    }

    private static int partition(int[] nums, int low, int high) {
        // 需要一个临时变量来存放基基准元素
        int pivot = nums[low];

        // 左右子针
        int left = low;

        int right = high;

        while (left < right) {

            // 右子针先从后往前，直到遇到小于或等于pivot的元素
            while (right > low && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];

            // 左子针从前往后，直到遇到大于pivot的元素
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 左半部分为小于或等于pivot
        nums[left] = pivot;
        return  left;
    }
}
