package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description: 冒泡排序
 **/
public class BubbleSort {

    public static void bubbleSort(int[] nums) {

        // 每趟排序将最大的元素下沉到底部
        for (int i = 0; i < nums.length - 1; i++) {

            // 优化：如果内排序没有交换过元素，则说明已经有序
            boolean hasSwap = false;

            // 排序内从前往后依次比较前后两个元素，如果前面的比后面大则交换位置，故一次排序之后当前最大的元素下沉到了底部
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    hasSwap = true;
                }
            }

            // 已经有序
            if (!hasSwap) {
                break;
            }
        }

        TestData.printArray(nums);
    }
}
