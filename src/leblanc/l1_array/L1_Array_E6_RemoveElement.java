package leblanc;

/**
 * LC27
 * 给你一个数组 nums 和一个值 val
 * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-20
 */
public class L1_Array_E6_RemoveElement {

    //1.暴力解法
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
                i--;
            }
        }
        return length;
    }

    //2.双指针
    public int removeElement1(int[] nums, int val) {
        int slowIndex = 0, fastIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
