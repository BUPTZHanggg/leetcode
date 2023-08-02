package leblanc.l3_hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC15
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c
 * 使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-22
 */
public class L3_HashTable_E7_ThreeSum {

    public static void main(String[] args) {
        L3_HashTable_E7_ThreeSum cl = new L3_HashTable_E7_ThreeSum();
        int[] a = new int[]{0,0,0,0,0,0};
        System.out.println(cl.threeSum(a));
    }

    public List<List<Integer>> threeSum0(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (i > 0 && nums[i - 1] == curr) continue;
            if (curr > 0) {
                return res;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + curr > 0) {
                    right--;
                } else if (nums[left] + nums[right] + curr < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(curr, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    //循环+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
