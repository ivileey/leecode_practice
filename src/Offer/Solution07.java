package Offer;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 07.重建二叉树
 * @author: Yuner
 * @create: 2020-10-10 11:00
 **/
public class Solution07 {

   HashMap<Integer, Integer> dic = new HashMap<>();
   int[] po;
   public TreeNode buildTree(int[] preorder, int[] inorder) {
      po = preorder;
      for (int i = 0; i < preorder.length; i++) {
         dic.put(inorder[i],i);
      }
      return recur(0 , 0, inorder.length - 1);
   }

   TreeNode recur(int pre_root, int in_left, int in_right) {
      if (in_left > in_right) return null;

      TreeNode root = new TreeNode(po[pre_root]);
      int i = dic.get(po[pre_root]);
      root.left = recur(pre_root + 1, in_left, i - 1);
      root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
      return root;
   }

}
