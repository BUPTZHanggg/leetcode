package leblanc.l7_bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

/**
 * LC102
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
 * （即逐层地，从左到右访问所有节点）。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-01
 */
public class L7_BT_E2_LevelOrder {

    /**
     *       2
     *      / \
     *    3    4
     *   / \
     *  1   6
     */
    public static void main(String[] args) {
        L7_BT_E2_LevelOrder cl = new L7_BT_E2_LevelOrder();
        TreeNode root = TreeNode.commonTree();
        System.out.println(cl.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode currNode = queue.poll();
                curr.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                len--;
            }
            res.add(curr);
        }
        return res;
    }
}
