package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * LC257
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-14
 */
public class L7_BT_E8_BinaryTreePaths {

    public static void main(String[] args) {
        L7_BT_E8_BinaryTreePaths cl = new L7_BT_E8_BinaryTreePaths();
        TreeNode root = TreeNode.commonTree();
        System.out.println(cl.binaryTreePaths0(root));
    }

    //递归 回溯
    public List<String> binaryTreePaths0(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        path(root, path, res);
        return res;
    }

    private void path(TreeNode root, List<TreeNode> path, List<String> res) {
        path.add(root);
        if (root.left == null && root.right == null) {
            String currPath = "";
            for (int i = 0; i < path.size() - 1; i++) {
                currPath += path.get(i).val;
                currPath += "->";
            }
            currPath += path.get(path.size() - 1).val;
            res.add(currPath);
            return;
        }
        if (root.left != null) {
            path(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }

    //迭代
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push(root.val + "");
        while (!nodeStack.isEmpty()) {
            String currPath = pathStack.pop();
            TreeNode currNode = nodeStack.pop();
            if (currNode.left == null && currNode.right == null) {
                res.add(currPath);
                continue;
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                pathStack.push(currPath + "->" + currNode.right.val);
            }
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                pathStack.push(currPath + "->" + currNode.left.val);
            }
        }
        return res;
    }
}
