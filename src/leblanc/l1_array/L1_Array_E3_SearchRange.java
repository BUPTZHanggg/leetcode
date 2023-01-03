package leblanc.l1_array;

import java.util.Arrays;

/**
 * LC34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-14
 */
public class L1_Array_E3_SearchRange {

    public static void main(String[] args) {
        L1_Array_E3_SearchRange cl = new L1_Array_E3_SearchRange();
        int[] nums = new int[] {5,7,7,8,8,10};
        System.out.println(Arrays.toString(cl.searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int leftBounder = getLeftBorder(nums, target);
        int rightBounder = getRightBorder(nums, target);
        if (leftBounder == -2 || rightBounder == -2) {
            return new int[]{-1, -1};
        }
        if (rightBounder - leftBounder > 1) {
            return new int[]{leftBounder + 1, rightBounder - 1};
        }
        return new int[]{-1, -1};
    }

    //返回不包含target的右边界
    //target在数组左侧，返回-2
    //target在数组右侧，返回nums.length
    private int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else { //为了取右边界，<=target 就要将左指针右移，并记录
                left = mid + 1;
                res = left;
            }
        }
        return res;
    }

    //返回不包含target的左边界
    //target在数组左侧，返回-1
    //target在数组右侧，返回-2
    private int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = -2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {//为了取左边界，>=target 就要将右指针左移，并记录
                right = mid - 1;
                res = right;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
