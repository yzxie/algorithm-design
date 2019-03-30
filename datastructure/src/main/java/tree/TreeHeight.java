package tree;

/**
 * @author xieyizun
 * @date 30/3/2019 21:26
 * @description:
 */
public class TreeHeight {

    /**
     * 任意树节点的高度
     * @param treeNode，输入可以是任意节点，如果是根节点则是树的高度
     * @param <T>
     * @return
     */
    public <T> int treeNodeHeight(BinaryTree<T> treeNode) {
        if (treeNode == null) {
            return -1;
        }

        return 1 + Math.max(treeNodeHeight(treeNode.left), treeNodeHeight(treeNode.right));
    }

    /**
     * 树的深度
     * @param root，输入只能是树的根节点，计算树的深度，如果是其他节点，则是到跟节点的距离，不是这样计算。
     * @param <T>
     * @return
     */
    public <T> int treeDeep(BinaryTree<T> root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(treeDeep(root.left), treeDeep(root.right));
    }

    public static void main(String[] args) {
        // 先序（root -> left -> right）遍历结果：4,3,1,2,5,6,7
        BinaryTree<Integer> root = TreeBuilder.buildCommonTree();
        TreeHeight height = new TreeHeight();
        System.out.println(height.treeNodeHeight(root));
        System.out.println(height.treeDeep(root));
    }
}
