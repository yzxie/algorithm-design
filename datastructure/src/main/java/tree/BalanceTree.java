package tree;

/**
 * @author xieyizun
 * @date 21/5/2019 23:06
 * @description: https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class BalanceTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        int leftHeight = calTreeHeight(root.left);
        int rightHeight = calTreeHeight(root.right);

        int diff = leftHeight > rightHeight ? leftHeight - rightHeight : rightHeight - leftHeight;

        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int calTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = calTreeHeight(root.left);
        int rightHeight = calTreeHeight(root.right);

        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
}
