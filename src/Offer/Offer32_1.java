package Offer;

import Common.TreeNode;

import java.util.*;


/**
 * @description: 32.从上到下打印二叉树
 * @author: Yuner
 * @create: 2020-10-13 20:43
 **/
public class Offer32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()) {
            TreeNode node = deque.poll();
            list.add(node.val);
            if (node.left != null) deque.add(node.left);
            if (node.right != null) deque.add(node.right);
        }
        int[] nums = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
