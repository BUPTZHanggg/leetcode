package leblanc;

import java.util.HashMap;
import java.util.Map;

/**
 * LC454
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n
 * 请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-20
 */
public class L3_HashTable_E5_FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int temp = a + b;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        int res = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                int currNeed = -(c + d);
                if (map.containsKey(currNeed)) {
                    res += map.get(currNeed);
                }
            }
        }
        return res;
    }
}
