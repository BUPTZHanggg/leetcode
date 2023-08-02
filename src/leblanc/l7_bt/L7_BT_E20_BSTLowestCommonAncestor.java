package leblanc.l7_bt;

import java.util.HashSet;
import java.util.Set;

import common.TreeNode;

/**
 * LC235
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *  所有节点的值都是唯一的。
 *  p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-06
 */
public class L7_BT_E20_BSTLowestCommonAncestor {

    public static void main(String[] args) {
        String sql = "alter table `gifshow`.video_live_record_chat_metadata_%d engine=innodb;";
        for (int i = 60; i < 100; i++) {
            System.out.println(String.format(sql, i));
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
