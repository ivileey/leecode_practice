package Contest.Contest11_12;

import Common.TreeNode;

import java.util.HashMap;

/**
 * @description:
 * @author: Yuner
 * @create: 2020-11-12 10:41
 **/
public class Offer07 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(0, 0, inorder.length - 1);
    }

    private TreeNode build(int pre, int in_index, int in_end) {
        if (in_index > in_end) {
            return null;
        }
        TreeNode node = new TreeNode(po[pre]);
        int i = map.get(po[pre]);
        node.left = build(pre + 1, in_index, i - 1);
        node.right = build(pre + i + 1 - in_index, i + 1, in_end);
        return node;
    }
}
