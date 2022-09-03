package step1;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-06
 */
public class S1_Array_E3_P27_RemoveElement {

    public static void main(String[] args) {
        S1_Array_E3_P27_RemoveElement p27 = new S1_Array_E3_P27_RemoveElement();
        int[] nums = new int[]{2,3,3,2,2};
        System.out.println(p27.twoPoint_removeElement(nums,3));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    //双指针
    public int twoPoint_removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]= temp;
        }
        return nums[left] == val ? left : left + 1;
    }

}
