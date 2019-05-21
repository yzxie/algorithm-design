package tree;

/**
 * @author xieyizun
 * @date 21/5/2019 23:09
 * @description:
 */
public class MaxSameTree {
    private int maxL = 0;
    public int longestUnivaluePath(TreeNode root) {
        /**
         解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
         2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
         需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
         **/

        if (root==null)
            return 0;
        getMaxL(root, root.val);
        return maxL;
    }

    public int getMaxL(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }

        int left = getMaxL(root.left, root.val);
        int right = getMaxL(root.right, root.val);

        maxL = Math.max(maxL, left+right);// 路径长度为节点数减1所以此处不加1
        if (root.val == val) {
            return Math.max(left, right) + 1;// 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
        }
        return 0;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
