package Offer;

import Common.TreeNode;

/**
 * @description: 平衡二叉树
 * @author: Yuner
 * @create: 2020-11-03 16:44
 **/
public class Offer55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
       if (root == null) return 0;
       return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private boolean solution2 (TreeNode root) {
        if (root == null)
            return true;
        return recur(root) == -1 ? false : true;
    }
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right) + 1;
    }
}
