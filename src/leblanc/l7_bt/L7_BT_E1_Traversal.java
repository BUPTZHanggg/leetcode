package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * 二叉树的遍历
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-31
 */
public class L7_BT_E1_Traversal {

    /**
     *       2
     *      / \
     *    3    4
     *   / \
     *  1   6
     */
    public static void main(String[] args) {
        L7_BT_E1_Traversal traversal = new L7_BT_E1_Traversal();
        TreeNode root = TreeNode.commonTree();
        List<Integer> res = new ArrayList<>();
        traversal.unify_postOrder(root, res);
        System.out.println(res);
    }

    /**
     * 1.迭代前序、后序
     *      遍历树，访问的节点与要处理的节点一致，处理当前节点，并将左右孩子按顺序入栈即可
     * 2.迭代中序
     *      访问的节点与要处理的节点不一致，先向左遍历依次入栈，直到访问的节点为空，弹出栈顶元素并处理，然后向右遍历重复之前的流程
     * 3.统一迭代法
     *      按顺序入栈，且对于要处理的节点，在入栈之后添加一个标识node，出栈时如果是标识node，则处理节点，否则按顺序继续入栈
     */
    //============================================================
    //1. LC144  二叉树前序遍历
    //============================================================

    //1.1 递归前序
    public void rec_preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        rec_preorder(root.left, res);
        rec_preorder(root.right, res);
    }

    //1.2 迭代前序
    private void ite_preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
    }

    //1.3 统一迭代前序
    private void unify_preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.val == 10086) {
                TreeNode toHandle = st.pop();
                res.add(toHandle.val);
            } else {
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
                st.push(new TreeNode(10086));
            }
        }
    }

    //============================================================
    //2. LC145  二叉树后序遍历
    //============================================================

    //2.1 递归后序
    private void rec_postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        rec_postOrder(root.left, res);
        rec_postOrder(root.right, res);
        res.add(root.val);
    }

    //2.2 迭代后序
    private void ite_postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);
            if (curr.left != null) {
                st.push(curr.left);
            }
            if (curr.right != null) {
                st.push(curr.right);
            }
        }
        Collections.reverse(res);
    }

    //2.3 统一迭代后序
    private void unify_postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.val == 10086) {
                TreeNode toHandle = st.pop();
                res.add(toHandle.val);
            } else {
                st.push(node);
                st.push(new TreeNode(10086));
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
            }
        }
    }

    //============================================================
    //3. LC94  二叉树中序遍历
    //============================================================

    //3.1 递归中序
    private void rec_inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        rec_postOrder(root.left, res);
        res.add(root.val);
        rec_postOrder(root.right, res);
    }

    //3.2 迭代中序
    private void ite_inorder(TreeNode root, List<Integer> res) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
    }

    //3.3 统一迭代中序
    private void unify_inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.val == 10086) {
                TreeNode toHandle = st.pop();
                res.add(toHandle.val);
            } else {
                if (node.right != null) {
                    st.push(node.right);
                }
                st.push(node);
                st.push(new TreeNode(10086));
                if (node.left != null) {
                    st.push(node.left);
                }
            }
        }
    }
}
