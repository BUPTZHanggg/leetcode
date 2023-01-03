package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC404
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-27
 */
public class L7_BT_E9_SumOfLeftLeaves {

    public static void main(String[] args) {
        L7_BT_E9_SumOfLeftLeaves cl = new L7_BT_E9_SumOfLeftLeaves();
        TreeNode root = TreeNode.commonTree();
        System.out.println(cl.sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }
        return sum(root.left, true) + sum(root.right, false);
    }
}
