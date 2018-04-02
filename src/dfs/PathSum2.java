package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu on 18/08/2017.
 */
/*
Given a binary tree and a sum, find all ROOT-TO-LEAF paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        dfs(root, ret, new ArrayList<Integer>(), sum);

        return ret;
    }
    public void dfs(TreeNode root, List<List<Integer>> paths, List<Integer> path, int sum) {
        if (root == null)
            return;
        path.add(root.val);

        //path必须是从根节点到 叶子节点
        if (root.left == null && root.right == null && sum == root.val)
            paths.add(path);

        //如果不满足sum
        dfs(root.left, paths, path, sum - root.val);
        dfs(root.right, paths, path, sum - root.val);

        // unmake
        path.remove(path.size() - 1);
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