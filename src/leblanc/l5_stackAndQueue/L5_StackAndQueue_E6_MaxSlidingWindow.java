package leblanc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LC239 hard
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * #
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-08-18
 */
public class L5_StackAndQueue_E6_MaxSlidingWindow {

    public static void main(String[] args) {
        L5_StackAndQueue_E6_MaxSlidingWindow cl = new L5_StackAndQueue_E6_MaxSlidingWindow();
        int[] nums = new int[]{1,3,3,-3,5,3,6,7};
        System.out.println(Arrays.toString(cl.maxSlidingWindow(nums, 2)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i >= k && deque.peek() == nums[i - k]) {
                deque.poll();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offer(nums[i]);
            if (i >= k - 1) {
                res[resIndex++] = deque.peek();
            }
        }
        return res;
    }
}
