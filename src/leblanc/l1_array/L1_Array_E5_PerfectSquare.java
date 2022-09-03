package leblanc.l1_array;

/**
 * LC367
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 1 <= num <= 2^31 - 1
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-20
 */
public class L1_Array_E5_PerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (num / mid == mid) {
                return mid * mid == num;
            } else if (num / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
