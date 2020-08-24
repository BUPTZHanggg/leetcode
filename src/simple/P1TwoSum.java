package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用一个map  k存数组中的值 v存下标
 * 遍历数组即可
 */
public class P1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 18)));;
    }



}
