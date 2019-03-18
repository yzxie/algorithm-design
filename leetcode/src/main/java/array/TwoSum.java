package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xieyizun
 * @date 13/3/2019 11:37
 * @description: 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int other = target - num;
            if (numAndIndex.get(other) != null) {
                return new int[]{numAndIndex.get(other), i};
            } else {
                numAndIndex.put(num, i);
            }
        }
        return new int[]{};
    }
}
