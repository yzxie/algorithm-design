package tree;

/**
 * @author xieyizun
 * @date 30/3/2019 10:57
 * @description:
 */

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
    }
}
