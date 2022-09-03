package leblanc;

import java.util.HashSet;
import java.util.Set;

/**
 * LC349
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-18
 */
public class L3_HashTable_E2_Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums1) {
            numSet.add(num);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (numSet.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] res = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            res[index++] = num;
        }
        return res;
    }
}
