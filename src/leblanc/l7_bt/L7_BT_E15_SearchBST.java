package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC700
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 *
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-11-28
 */
public class L7_BT_E15_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
