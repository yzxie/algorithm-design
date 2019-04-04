package tree;

/**
 * @author xieyizun
 * @date 2/4/2019 18:35
 * @description:
 */
public class LowestParent {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归底层的退出条件
        if (root == null) {
            return null;
        }
        // 要么在根，递归底层递归的退出条件
        if (root == p || root == q) {
            return root;
        }

        // 要么在左子树，要么在右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 由退出条件：root==null则返回null，root == p || root == q则返回root，
        // 如果p和q分别在左右子树，则左子树返回为p，右子树返回为q
        if (left != null && right != null) {
            return root;
        }

        // 在左子树，则右子树返回null
        if (left != null) {
            return left;
        }

        // 在右子树，则左子树返回null
        if (right != null) {
            return right;
        }

        return null;
    }
}
