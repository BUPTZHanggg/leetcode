package leblanc;

import java.util.Arrays;

/**
 * LC283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-21
 */
public class L1_Array_E8_MoveZeroes {

    public static void main(String[] args) {
        L1_Array_E8_MoveZeroes cl = new L1_Array_E8_MoveZeroes();
        int [] a = new int[] {0,1,1,0,2,2,0};
        cl.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        for (; slowIndex < nums.length; slowIndex++) {
            nums[slowIndex] = 0;
        }
    }
}
