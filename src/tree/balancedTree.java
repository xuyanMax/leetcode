package tree;

/**
 * 
 * @author xu
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the 
 * depth of the two subtrees of every node never differ by more than 1.
 * 
 * https://leetcode.com/problems/balanced-binary-tree/#/description
 * 
 */
public class balancedTree {

	public static void main(String[] args) {
	

	}
	static boolean isBalanced(AvlNode root) {
		if (root==null) return true;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if (Math.abs(leftHeight - rightHeight) > 1) return false;
		
		return isBalanced(root.left) && isBalanced(root.right);
	}
	static int height(AvlNode root) {
		
		if (root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

}
