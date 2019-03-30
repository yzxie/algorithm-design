package tree;

/**
 * @author xieyizun
 * @date 30/3/2019 10:57
 * @description:
 */

public class BinaryTree<T> {
    public T val;
    public BinaryTree<T> left;
    public BinaryTree<T> right;

    public BinaryTree(T val) {
        this.val = val;
    }
}
