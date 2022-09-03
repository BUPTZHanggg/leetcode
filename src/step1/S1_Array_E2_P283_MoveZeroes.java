package step1;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-06
 */
public class S1_Array_E2_P283_MoveZeroes {
    public static void main(String[] args) {
        S1_Array_E2_P283_MoveZeroes p283 = new S1_Array_E2_P283_MoveZeroes();
        int[] nums = new int[]{0};
        p283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index;i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
