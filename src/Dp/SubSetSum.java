package Dp;

/**
 * 给定一个数组
 * 判断是否存在子序列 满足和等于给定的数
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-11-06
 */
public class SubSetSum {

    public static void main(String[] args) {
        int[] a = new int[] {3,34,4,12,5,2};
        System.out.println(rec_exist(a, 9,a.length - 1));
        System.out.println(rec_exist(a, 10,a.length - 1));
        System.out.println(rec_exist(a, 11,a.length - 1));
        System.out.println(rec_exist(a, 12,a.length - 1));
        System.out.println(rec_exist(a, 13,a.length - 1));
        System.out.println(dp_exist(a, 9,a.length - 1));
        System.out.println(dp_exist(a, 10,a.length - 1));
        System.out.println(dp_exist(a, 11,a.length - 1));
        System.out.println(dp_exist(a, 12,a.length - 1));
        System.out.println(dp_exist(a, 13,a.length - 1));
    }

    /**
     * 递归解法
     * @param array 元素均为正整数
     * @param sum sum >= 0
     * @return
     */
    public static boolean rec_exist(int[] array, int sum, int i) {
        if (i == 0) {
            return array[0] == sum;
        }
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        return rec_exist(array, sum, i - 1)
                || rec_exist(array, sum - array[i], i - 1);
    }

    /**
     * dp解法
     * @param array
     * @param sum
     * @return
     */
    public static boolean dp_exist(int[] array, int sum, int i) {
        boolean[][] dp_result = new boolean[array.length][sum + 1];
        for (int m = 0; m < array.length; m++) {
            dp_result[m][0] = true;
        }
        dp_result[0][array[0]] = true;
        for (int m = 1; m < array.length; m++) {
            for (int n = 1; n <= sum; n++) {
                boolean A = dp_result[m - 1][n]; //不选array[m]
                boolean B = array[m] <= n && dp_result[m - 1][n - array[m]]; //在特定情况下 选了array[m]
                dp_result[m][n] = A || B;
            }
        }
        return dp_result[array.length - 1][sum];
    }
}
