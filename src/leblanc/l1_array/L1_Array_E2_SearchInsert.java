package leblanc.l1_array;

/**
 * LC35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 提示:
 *  -nums 为无重复元素的升序排列数组
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-11
 */
public class L1_Array_E2_SearchInsert {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,6};
        L1_Array_E2_SearchInsert cl = new L1_Array_E2_SearchInsert();
        System.out.println(cl.searchInsert2(a, 5));
    }

    //1.1暴力解法
    public int searchInsert1(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    //1.2二分法
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
