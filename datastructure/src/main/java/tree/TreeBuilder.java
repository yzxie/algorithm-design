package tree;

/**
 * @author xieyizun
 * @date 30/3/2019 11:04
 * @description:
 */
public class TreeBuilder {

    public static TreeNode<Integer> buildOrderBinaryTree(int[] elements) {
        return null;
    }

    /**
     * 先序（root -> left -> right）遍历结果：4,3,1,2,5,6,7
     * @return
     */
    public static TreeNode<Integer> buildCommonTree() {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> left = new TreeNode<>(3);
        TreeNode<Integer> right = new TreeNode<>(5);
        root.left = left;
        root.right = right;

        TreeNode<Integer> left1 = new TreeNode<>(1);
        TreeNode<Integer> right1 = new TreeNode<>(2);
        left.left = left1;
        left.right = right1;

        TreeNode<Integer> left2 = new TreeNode<>(6);
        TreeNode<Integer> right2 = new TreeNode<>(7);
        right.left = left2;
        right.right = right2;

        return root;
    }
}
