package array;

/**
 * @author xieyizun
 * @date 6/4/2019 23:05
 * @description:
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n > 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        // 从尾部往前比较并插入元素，避免元素移动（如果从头比较则需要移动nums1中的数据）
        int lastIndex = m + n - 1;
        if (lastIndex >= 0) {
            int i1 = m - 1;
            int i2 = n - 1;

            while (i1 >= 0 && i2 >= 0) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[lastIndex] = nums1[i1];
                    i1--;
                } else {
                    nums1[lastIndex] = nums2[i2];
                    i2--;
                }
                lastIndex--;
            }

            if (i2 >= 0) {
                while (lastIndex >= 0) {
                    nums1[lastIndex--] = nums2[i2--];
                }
            }
        }
    }
}
