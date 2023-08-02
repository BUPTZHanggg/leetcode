package leblanc.l1_array;

/**
 * LC69
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 0 <= x <= 2^31 - 1
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-04-20
 */
public class L1_Array_E4_MySqrt {

    public static void main(String[] args) {
        L1_Array_E4_MySqrt cl = new L1_Array_E4_MySqrt();
        System.out.println(cl.mySqrt(2));
    }

    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
