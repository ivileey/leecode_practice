package Contest;

import Common.TreeNode;

import java.util.HashMap;

/**
 * @description:
 * @author: Yuner
 * @create: 2020-11-09 15:03
 **/
public class Offer07 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, 0, inorder.length - 1);
    }
    public TreeNode build(int pre, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(po[pre]);
        int i = map.get(po[pre]);
        root.left = build(pre + 1, in_left,i - 1);
        root.right = build(i + 1 - in_left + pre, i + 1, in_right);
        return root;
    }
}