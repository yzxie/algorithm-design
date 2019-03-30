package tree;

import java.util.*;

/**
 * @author xieyizun
 * @date 30/3/2019 10:59
 * @description:
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历：root -> left -> right
     * @param root
     */
    public void preTraversalRecursive(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }

        // root
        System.out.print(root.val + ",");

        // left
        if (root.left != null) {
            preTraversalRecursive(root.left);
        }

        // right
        if (root.right != null) {
            preTraversalRecursive(root.right);
        }
    }

    // 结合栈（后进先出）来实现：根先入栈，然后开始循环遍历：根节点出栈，先右子树入栈，然后是左子树入栈；左子树出栈...
    public void preTraversal(BinaryTree<Integer> root) {
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.push(root);

        while (!stack.isEmpty()) {
            BinaryTree<Integer> current = stack.pop();

            // root
            System.out.print(current.val + ",");

            // 由于栈是后入先出，故右子树先入栈，左子树后入栈，则左子树先出栈，右子树先出栈
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 中序遍历：left -> root -> right
     * @param root
     */
    public void midTraversalRecursive(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }

        // left
        if (root.left != null) {
            midTraversalRecursive(root.left);
        }

        // root
        System.out.print(root.val + ",");

        // right
        if (root.right != null) {
            midTraversalRecursive(root.right);
        }
    }

    public void midTraversal(BinaryTree<Integer> root) {
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        // 记录左右子树已经入过栈的根节点
        Map<BinaryTree, Boolean> childIsInStack = new HashMap<>();

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.val);
            return;
        }

        // right
        if (root.right != null) {
            stack.push(root.right);
        }

        // root
        stack.push(root);

        // left
        if (root.left != null) {
            stack.push(root.left);
        }

        childIsInStack.put(root, true);

        while (!stack.isEmpty()) {
            // 出栈
            BinaryTree<Integer> current = stack.pop();

            if (current.left == null && current.right == null) {
                System.out.print(current.val + ",");
            } else {
                // 检查当前节点current的左右节点是否已经入过栈过，如果是则直接输出，避免死循环
                if (childIsInStack.get(current) == null) {
                    // 非叶子节点，则右子树先入栈，左子树再入栈
                    if (current.right != null) {
                        stack.push(current.right);
                    }

                    // root
                    // 子树的root重新入栈，保证栈的顺序为：right -> root -> left，其中left在栈顶
                    childIsInStack.put(current, true);
                    stack.push(current);

                    // left
                    if (current.left != null) {
                        stack.push(current.left);
                    }
                } else {
                    System.out.print(current.val + ",");
                }
            }
        }
    }

    /**
     * 后序遍历：left -> right -> root
     * @param root
     */
    public void postTraversalRecursive(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }

        // left
        if (root.left != null) {
            postTraversalRecursive(root.left);
        }

        // right
        if (root.right != null) {
            postTraversalRecursive(root.right);
        }

        // root
        System.out.print(root.val + ",");
    }

    public void postTraversal(BinaryTree<Integer> root) {
        Stack<BinaryTree<Integer>> stack = new Stack<>();
        // 记录左右子树已经入过栈的根节点
        Map<BinaryTree, Boolean> childIsInStack = new HashMap<>();

        if (root == null) {
            return;
        }

        // root
        stack.push(root);

        // right
        if (root.right != null) {
            stack.push(root.right);
        }

        // left
        if (root.left != null) {
            stack.push(root.left);
        }

        childIsInStack.put(root, true);

        while (!stack.isEmpty()) {
            // 出栈
            BinaryTree<Integer> current = stack.pop();

            // 叶子节点
            if (current.left == null && current.right == null) {
                System.out.print(current.val + ",");
            } else {
                if (childIsInStack.get(current) == null) {
                    // root为最后访问的，故重新入栈中，保证顺序：root -> right -> left
                    // 同时要避免下次访问到该root时，进行进入该逻辑导致死循环
                    stack.push(current);
                    childIsInStack.put(current, true);

                    // 非叶子节点，则右子树先入栈，左子树再入栈；之后左子树先出栈，右子树先出栈
                    if (current.right != null) {
                        stack.push(current.right);
                    }

                    if (current.left != null) {
                        stack.push(current.left);
                    }
                } else {
                    // 左右子树都处理过了，则直接出栈
                    System.out.print(current.val + ",");
                }
            }
        }
    }

    /**
     * 树的层次遍历，时间复杂度为O(N)
     * @param root
     */
    public void treeLevelTraversal(BinaryTree<Integer> root) {
        if (root == null) {
            return;
        }

        // 结合FIFO队列来实现
        ArrayDeque<BinaryTree<Integer>> queue = new ArrayDeque<BinaryTree<Integer>>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            BinaryTree<Integer> ele = queue.pollFirst();
            System.out.print(ele.val + ",");

            if (ele.left != null) {
                queue.offerLast(ele.left);
            }

            if (ele.right != null) {
                queue.offerLast(ele.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = TreeBuilder.buildCommonTree();

        BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();

        // 4,3,1,2,5,6,7
        System.out.println("pre: ");
        treeTraversal.preTraversalRecursive(root);
        System.out.println();
        treeTraversal.preTraversal(root);
        System.out.println();

        // 1,3,2,4,6,5,7
        System.out.println("mid: ");
        treeTraversal.midTraversalRecursive(root);
        System.out.println();
        treeTraversal.midTraversal(root);
        System.out.println();

        // 1,2,3,6,7,5,4
        System.out.println("post: ");
        treeTraversal.postTraversalRecursive(root);
        System.out.println();
        treeTraversal.postTraversal(root);
        System.out.println();

        // 4,3,5,1,2,6,7
        System.out.println("level: ");
        treeTraversal.treeLevelTraversal(root);
    }
}
