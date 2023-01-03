package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * LC101
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-06
 */
public class L7_BT_E4_IsSymmetric {

    //递归
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            return node1.val == node2.val && isEqual(node1.left, node2.right)
                    && isEqual(node1.right, node2.left);
        }
        return false;
    }

    //迭代
    public boolean isSymmetric0(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while (!st.isEmpty()) {
            TreeNode right = st.pop();
            TreeNode left = st.pop();
            if (right == null && left == null) {
                continue;
            }
            if (right != null && left != null && right.val == left.val) {
                st.push(left.left);
                st.push(right.right);
                st.push(left.right);
                st.push(right.left);
                continue;
            }
            return false;
        }
        return true;
    }
}
