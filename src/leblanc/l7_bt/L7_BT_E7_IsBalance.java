package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC110
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-09
 */
public class L7_BT_E7_IsBalance {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }
}
