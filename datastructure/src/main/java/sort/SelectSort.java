package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description:
 **/
public class SelectSort {

    public static void selectSort(int[] nums) {

        // 分为已排序和待排序，每次从待排序选择一个最小元素放到已排序末尾，通过交换的方式
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {

                // 不断查找最小元素
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换位置
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        TestData.printArray(nums);
    }
}
