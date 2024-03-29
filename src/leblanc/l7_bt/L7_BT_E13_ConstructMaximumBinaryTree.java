package leblanc.l7_bt;

import common.TreeNode;

/**
 * LC654
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-10-27
 */
public class L7_BT_E13_ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxValue = nums[left];
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode curr = new TreeNode(maxValue);
        curr.left = construct(nums, left, maxIndex - 1);
        curr.right = construct(nums, maxIndex + 1, right);
        return curr;
    }
}
