package leblanc.l7_bt;

import java.util.Stack;

import common.TreeNode;

/**
 * LC538
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同
 * 请你将其转换为累加树（Greater Sum Tree）
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-13
 */
public class L7_BT_E25_ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, pre = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                TreeNode pop = stack.pop();
                if (pre != null) {
                    pop.val += pre.val;
                }
                pre = pop;
                curr = pop.left;
            }
        }
        return root;
    }
}
