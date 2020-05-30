package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description: 希尔排序
 **/
public class ShellSort {

    public static void shellSort(int[] nums) {
        // 缩减增量的插入排序
        // 每次与前面间隔gap的元素比较，直到gap为1
        int gap = nums.length / 2;

        while (gap > 0) {
            // 从gap坐标开始与前面的元素比较，比较间隔为gap
            for (int i = gap; i < nums.length; i++) {

                // 与前面的元素比较，前面元素已有序
                int j = i - gap;
                for (; j >= 0; j = j - gap) {
                    if (nums[j] > nums[i]) {
                        nums[j + gap] = nums[j];
                    } else {
                        nums[j + gap] = nums[i];
                        break;
                    }
                }
            }

            // 增量减半
            gap /= 2;
        }

        TestData.printArray(nums);
    }
}
