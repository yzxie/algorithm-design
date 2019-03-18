package array;

/**
 * @author xieyizun
 * @date 13/3/2019 11:44
 * @description:
 */
public class RemoveElement {


    /**
     * 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    /**
     * 27. 移除元素 https://leetcode-cn.com/problems/remove-element/
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 80. 删除排序数组中的重复项 II：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public int removeDuplicatesV2(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 0;
        // 从第3个开始，因为前面两个相同和不同都要保留
        for (int i = 2; i < nums.length; i++) {
            // 如果第3个与第1个不同，则第3个是合格的，因为升序的，不会3个相同
            // 但是2和3可能相同，则第4个应该与第2个比
            if (nums[index] != nums[i]) {
                nums[++index+1] = nums[i];
            }
        }

        // 每隔2个来比，比较结束后index距离末尾2个元素
        return index + 2;
    }
}
