package tree;

/**
 * @author xieyizun
 * @date 30/3/2019 11:04
 * @description:
 */
public class TreeBuilder {

    public static BinaryTree<Integer> buildOrderBinaryTree(int[] elements) {
        return null;
    }

    /**
     * 先序（root -> left -> right）遍历结果：4,3,1,2,5,6,7
     * @return
     */
    public static BinaryTree<Integer> buildCommonTree() {
        BinaryTree<Integer> root = new BinaryTree<>(4);
        BinaryTree<Integer> left = new BinaryTree<>(3);
        BinaryTree<Integer> right = new BinaryTree<>(5);
        root.left = left;
        root.right = right;

        BinaryTree<Integer> left1 = new BinaryTree<>(1);
        BinaryTree<Integer> right1 = new BinaryTree<>(2);
        left.left = left1;
        left.right = right1;

        BinaryTree<Integer> left2 = new BinaryTree<>(6);
        BinaryTree<Integer> right2 = new BinaryTree<>(7);
        right.left = left2;
        right.right = right2;

        return root;
    }
}
