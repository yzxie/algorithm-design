package number;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xieyizun
 * @date 13/3/2019 11:47
 * @description: 9. 回文数 https://leetcode-cn.com/problems/palindrome-number/
 */
public class HuiwenNum {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x >=0 && x <= 9) {
            return true;
        } else {
            List<Integer> nums = new ArrayList<>();
            while (x > 0) {
                int num = x % 10;
                x /= 10;
                nums.add(num);
            }
            int i = 0;
            int j = nums.size() - 1;
            while (i < j) {
                if (nums.get(i) != nums.get(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
