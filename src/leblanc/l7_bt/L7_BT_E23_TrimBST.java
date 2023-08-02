package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC669
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该改变保留在树中的元素的相对结构(即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在唯一的答案。
 *  - 树中每个节点的值都是 唯一 的
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-09
 */
public class L7_BT_E23_TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }  else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
