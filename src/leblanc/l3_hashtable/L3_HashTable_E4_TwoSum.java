package leblanc;

import java.util.HashMap;
import java.util.Map;

/**
 * LC1
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。

 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-20
 */
public class L3_HashTable_E4_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNeed = target - nums[i];
            if (map.containsKey(currNeed)) {
                return new int[] {i, map.get(currNeed)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
