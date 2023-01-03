package leblanc.l7_bt;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * LC513
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-09-27
 */
public class L7_BT_E10_FindBottomLeftValue {

    public static void main(String[] args) {
        L7_BT_E10_FindBottomLeftValue cl = new L7_BT_E10_FindBottomLeftValue();
        TreeNode root = TreeNode.commonTree();
        System.out.println(cl.findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode left = root; //记录每一层最左侧的数据
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean markLeft = true;
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (markLeft) {
                    left = poll;
                    markLeft = false;
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
        return left.val;
    }

}
