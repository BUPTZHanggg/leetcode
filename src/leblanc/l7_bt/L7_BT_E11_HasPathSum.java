package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。

 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-27
 */
public class L7_BT_E11_HasPathSum {

    public static void main(String[] args) {
        L7_BT_E11_HasPathSum cl = new L7_BT_E11_HasPathSum();
        TreeNode root = TreeNode.commonTree();
        System.out.println(cl.hasPathSum(root, 111));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
