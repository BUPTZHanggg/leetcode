package leblanc.l1_array;

import java.util.Arrays;

/**
 * LC26
 * 给你一个升序排列的数组nums ，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 元素的相对顺序应该保持一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 1 <= nums.length <= 3 * 104
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-21
 */
public class L1_Array_E7_RemoveDuplicates {

    public static void main(String[] args) {
        L1_Array_E7_RemoveDuplicates cl = new L1_Array_E7_RemoveDuplicates();
        int [] a = new int[]{1,2,2,3,4,4,5};
        System.out.println(cl.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != nums[slowIndex]) {
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex + 1;
    }
}
