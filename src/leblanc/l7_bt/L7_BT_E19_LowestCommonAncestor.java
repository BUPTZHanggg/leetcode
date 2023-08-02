package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC236
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *  - 所有 Node.val 互不相同 。
 *  - p != q
 *  - p 和 q 均存在于给定的二叉树中。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-03
 */
public class L7_BT_E19_LowestCommonAncestor {

    //p 和 q 均存在于给定的二叉树中  这点很重要
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        }
        return null;
    }
}
