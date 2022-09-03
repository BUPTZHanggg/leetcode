package leblanc.l1_array;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * LC977
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-05
 */
public class L1_Array_E10_SortedSquares {

    public static void main(String[] args) {
        L1_Array_E10_SortedSquares cl = new L1_Array_E10_SortedSquares();
        int[] a = new int[] {-4, -1, 0, 3, 10};
        int[] ints = cl.sortedSquares(a);
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int leftIndex = 0, rightIndex = nums.length - 1;
        int slidingIndex = nums.length - 1;
        int[] res = new int[nums.length];
        while (leftIndex <= rightIndex) {
            if (Math.abs(nums[leftIndex]) > Math.abs(nums[rightIndex])) {
                res[slidingIndex--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            } else {
                res[slidingIndex--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }
}
