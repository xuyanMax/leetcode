package dfs;

/**
 * Created by xu on 28/12/2017.
 */
/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.


*/
public class BinaryTreeMaxPathSum {
    //需要变量记录全局最优解
    private int max = Integer.MIN_VALUE;
    //dfs 从底向上的，一路将左/右子树最大的path值更新到父节点，直到root节点
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = 0, right = 0;
        //最大右path
        left = Math.max(dfs(root.left), 0);
        //最大左path
        right = Math.max(dfs(root.right), 0);
        //包含该节点+左+右，倒V结构
        max = Math.max(root.val + left + right, max);
        //返回包含当前节点的一条直线path
        return root.val + Math.max(right, left);
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
