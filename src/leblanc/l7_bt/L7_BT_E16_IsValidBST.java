package leblanc.l7_bt;

import java.util.Stack;

import common.TreeNode;

/**
 * LC98
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-12-02
 */
public class L7_BT_E16_IsValidBST {

    public boolean isValidBST0(TreeNode root) {
        return isValidBST0(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST0(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST0(root.left, min, root.val) && isValidBST0(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null && pre.val >= pop.val) {
                    return false;
                }
                pre = pop;
                root = pop.right;
            }
        }
        return true;
    }
}
