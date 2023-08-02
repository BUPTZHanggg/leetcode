package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC450
 * 给定一个二叉搜索树的根节点 root 和一个值 key
 * 删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 *  - 节点数的范围[0, 10^4]
 *  - 节点值唯一
 *  - root是合法的二叉搜索树
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-08
 */
public class L7_BT_E22_DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else { //root即为要删除的节点
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else if (root.right != null && root.left == null) {
                return root.right;
            } else { //左孩子、右孩子都不为null
                TreeNode left = root.left;
                TreeNode right = root.right;
                TreeNode pre = null;
                while (right != null) {
                    pre = right;
                    right = right.left;
                }
                pre.left = left;
                return root.right;
            }
        }
        return root;
    }
}
