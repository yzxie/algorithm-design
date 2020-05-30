package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description:
 **/
public class InsertSort {

    public static void insertSort(int[] nums) {

        // 对于每一个元素都与其前面的所有元素对比，直到找到自己的位置，由于是从第一个元素开始的，故对于后面的元素，当轮到该元素时，
        // 前面的元素都是有序的了，故如果当前元素更小，则将前面的元素往后移即可
        for (int i = 1; i < nums.length; i++) {

            // 与其前面元素比较，如果前面元素更大，则将前面元素往后移
            int current = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {

                if (nums[j] > current) {
                    nums[j+1] = nums[j];
                } else {
                    // 找到合适位置
                    nums[j + 1] = current;
                    break;
                }
            }
        }

        TestData.printArray(nums);
    }
}
