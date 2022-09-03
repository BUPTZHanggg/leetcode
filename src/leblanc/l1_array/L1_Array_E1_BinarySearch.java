package leblanc;

/**
 * LC704
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-11
 */
public class L1_Array_E1_BinarySearch {

    public static void main(String[] args) {
        int [] a = new int[] {-1,0,3,5,9,12};
        L1_Array_E1_BinarySearch cl = new L1_Array_E1_BinarySearch();
        System.out.println(cl.search1(a, 9));
    }

    //1.左闭右闭写法
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target
                || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //2.左闭右开写法
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
