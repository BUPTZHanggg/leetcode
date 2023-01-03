package leblanc.l7_bt;

import java.util.ArrayDeque;
import java.util.Queue;

import common.TreeNode;

/**
 * LC111
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-08
 */
public class L7_BT_E5_MinDepth {

    //递归
    public int minDepth0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth0(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth0(root.left);
        }
        return 1 + Math.min(minDepth0(root.left), minDepth0(root.right));
    }



    //迭代
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return res;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
        }
        return res;
    }
}
