package leblanc.l7_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * LC501
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root
 * 找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2023-02-01
 */
public class L7_BT_E18_FindMode {

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        int count = 0, maxcount = 0;
        while(root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode curr = stack.pop();
                if (pre == null || curr.val != pre.val) {
                    count = 1;
                } else {
                    count++;
                }
                if (count > maxcount) {
                    maxcount = count;
                    list.clear();
                    list.add(curr.val);
                } else if (count == maxcount) {
                    list.add(curr.val);
                }
                pre = curr;
                root = curr.right;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
