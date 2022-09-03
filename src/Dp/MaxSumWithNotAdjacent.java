package Dp;

/**
 * 给定一个数组
 * 求其中一组子序列的最大值 要求子序列之间所有元素不相邻
 * @author
 * zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-11-06
 */
public class MaxSumWithNotAdjacent {

    public static void main(String[] args) {
        int[] a = new int[] {1,2 ,1,9,8,3,5};
        int[] b = new int[] {1, 2, 3};
        System.out.println(rec_maxSum(a, a.length - 1));
        System.out.println(dp_maxSum(a, a.length - 1));
        System.out.println(dp_maxSum(b));
    }

    public static int dp_maxSum(int[] array) {
        int[] res = new int[array.length];
        res[0] = array[0];
        if (array.length > 1) {
            res[1] = Math.max(array[1], array[0]);
        }
        for (int m = 2; m < res.length; m++) {
            int A = array[m] + res[m - 2];
            int B = array[m - 1];
            res[m] = Math.max(A, B);
        }
        return res[res.length - 1];
    }

    /**
     * 递归解法
     * @param array
     * @param i
     * @return
     */
    public static int rec_maxSum(int[] array, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return array[0];
        }
        int A = rec_maxSum(array, i - 1);  //不选array[i]
        int B = rec_maxSum(array, i - 2) + array[i]; //选array[i]
        return Math.max(A, B);
    }

    /**
     * dp解法
     * @param array
     * @param i i >= 0
     * @return
     */
    public static int dp_maxSum(int[] array, int i) {
        int[] dp_array = new int[i + 1];
        dp_array[0] = array[0];
        if (i == 0) {
            return array[0];
        }
        for (int m = 1; m <= i; m++) {
            if (m == 1) {
                dp_array[m] = Math.max(array[0], array[1]);
                continue;
            }
            int A = dp_array[m - 1]; //不选array[m]
            int B = dp_array[m - 2] + array[m]; //选array[m]
            dp_array[m] = Math.max(A, B);
        }
        return dp_array[i];
    }
}
