package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-02
 */
public class L7_BT_E3_InvertTree {

    /**
     *       2
     *      / \
     *    3    4
     *   / \
     *  1   6
     */
    public static void main(String[] args) {
        L7_BT_E3_InvertTree cl = new L7_BT_E3_InvertTree();
        TreeNode root = TreeNode.commonTree();
        TreeNode node = cl.invertTree0(root);
        L7_BT_E1_Traversal c = new L7_BT_E1_Traversal();
        List<Integer> res = new ArrayList<>();
        c.rec_preorder(node, res);
        System.out.println(res);
    }

    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    //前序遍历 翻转
    public TreeNode invertTree0(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode left = pop.left;
            pop.left = pop.right;
            pop.right = left;
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return root;
    }

}
