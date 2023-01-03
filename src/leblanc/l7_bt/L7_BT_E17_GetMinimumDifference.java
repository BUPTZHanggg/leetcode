package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * LC530
 * 一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-12-06
 */
public class L7_BT_E17_GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null && pop.val - pre.val < res) {
                    res = pop.val - pre.val;
                }
                pre = pop;
                root = pop.right;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
