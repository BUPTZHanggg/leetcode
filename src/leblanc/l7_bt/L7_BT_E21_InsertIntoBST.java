package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC701
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回 任意有效的结果 。
 *  - 树中的节点数将在[0,10^4]的范围内。
 *  - 所有值Node.val是独一无二的。
 *  - 保证val在原始BST中不存在。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-07
 */
public class L7_BT_E21_InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while (true) {
            if (curr.val > val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    return root;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    return root;
                }
            }
        }
    }
}
