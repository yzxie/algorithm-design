package sort;

/**
 * Author: xieyizun
 * Version: 1.0
 * Date: 2020/5/30
 * Description: 堆排序
 **/
public class HeapSort {

    /**
     * 堆是由完全二叉树结构，对应到数组，如果以0作为起始下标，
     * 则父节点与左右节点满足：父节点为i，左节点为2i+1，右节点为2i+2
     * 故长度为n的数组，初始的最低最右存在子节点的数组下标为 ((n-1)-1) / 2，其中n-1为数组最后一个元素的下标
     *
     * @param nums
     * @param recursive
     */
    public static void heapSort(int[] nums, boolean recursive) {

        // 初始大顶堆：自底向上
        int lastParentIndex = (nums.length-1 - 1) / 2;
        for (int parentIndex = lastParentIndex; parentIndex >= 0; parentIndex--) {
            if (recursive) {
                heapAdjustRecurse(nums, parentIndex, nums.length);
            } else {
                heapAdjust(nums, parentIndex, nums.length);
            }
        }

        // 每次将堆顶与待排序的数组尾部交换，然后在调整剩余的待排序数组所构成的堆：自顶向下
        for (int i = nums.length - 1; i >= 0; i--) {

            // 堆顶与堆的最后一个节点交换
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            // 调整堆，第一次循环时i=nums.length-1 ，即长度减1了，之后i--不断递减
            int length = i;
            if (recursive) {
                heapAdjustRecurse(nums, 0, length);
            } else {
                heapAdjust(nums, 0, length);
            }
        }

        TestData.printArray(nums);
    }


    // 调整堆：将父节点与左右节点的较大值比较，如果父节点更大，则说明已经符合大顶堆，无需往下调整
    // 否则将父节点与较大值交换位置，然后从较大值往下继续调整
    private static void heapAdjustRecurse(int[] nums, int parent, int length) {
        // 左节点：2 * parent + 1，右节点：2 * parent + 2
        int leftIndex = 2 * parent + 1;
        int rightIndex = 2 * parent + 2;

        // 父节点没有左右子节点
        if (leftIndex >= length) {
            return;
        }

        int biggerChildIndex = leftIndex;
        // 取左右节点的较大值与父节点比较
        if (rightIndex < length && nums[rightIndex] > nums[leftIndex]) {
            biggerChildIndex = rightIndex;
        }

        // 与父节点比较，如果父节点更大，则
        if (nums[parent] > nums[biggerChildIndex]) {
            return;
        } else {
            // 交换后
            int temp = nums[parent];
            nums[parent] = nums[biggerChildIndex];
            nums[biggerChildIndex] = temp;

            // 往下继续调整
            heapAdjust(nums, biggerChildIndex, length);
        }
    }

    // 非递归版
    private static void heapAdjust(int[] nums, int parent, int length) {

        // 左节点：2 * parent + 1，右节点：2 * parent + 2
        int leftIndex = 2 * parent + 1;
        int rightIndex = 2 * parent + 2;

        // 父节点没有左右子节点
        if (leftIndex >= length) {
            return;
        }

        int biggerChildIndex = leftIndex;

        while (biggerChildIndex < length) {
            // 取左右节点的较大值与父节点比较
            if (rightIndex < length && nums[rightIndex] > nums[leftIndex]) {
                biggerChildIndex = rightIndex;
            }

            // 与父节点比较，如果父节点更大，则
            if (nums[parent] > nums[biggerChildIndex]) {
                return;
            } else {
                // 交换后
                int temp = nums[parent];
                nums[parent] = nums[biggerChildIndex];
                nums[biggerChildIndex] = temp;

                // 往下继续调整
                parent = biggerChildIndex;
                biggerChildIndex = 2 * parent + 1;
            }
        }
    }
}
