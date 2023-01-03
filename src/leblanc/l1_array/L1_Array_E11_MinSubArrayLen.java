package leblanc.l1_array;

/**
 * LC209
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-06
 */
public class L1_Array_E11_MinSubArrayLen {

    public static void main(String[] args) {
        L1_Array_E11_MinSubArrayLen cl = new L1_Array_E11_MinSubArrayLen();
        int[] a = new int[] {2,3,1,2,4,3};
        System.out.println(cl.minSubArrayLen(70,a));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int result = Integer.MAX_VALUE;
        int i = 0;//窗口开始位置
        for (int j = 0; j < nums.length; j++) { //j为窗口结束位置
            currSum += nums[j];
            while (currSum >= target) {
                result = Math.min(result, j - i + 1);
                currSum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
