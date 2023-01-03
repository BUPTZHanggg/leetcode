package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC617
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null
 * 的节点将直接作为新二叉树的节点。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-11-20
 */
public class L7_BT_E14_MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
