package leblanc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC18
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c],nums[d]] 
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-23
 */
public class L3_HashTable_E8_FourSum {

    public static void main(String[] args) {
        L3_HashTable_E8_FourSum cl = new L3_HashTable_E8_FourSum();
        int[] a = new int[]{1,0,-1,0,-2,2};
        System.out.println(cl.fourSum(a, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
