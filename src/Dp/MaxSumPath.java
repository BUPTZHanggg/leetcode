package Dp;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-16
 */

import java.util.Scanner;

/**
 *
 *      7
 *    3   8
 *   8  1  10
 *  2  7  4  4
 * 4  5  2  6  5
 *
 */
public class MaxSumPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 5;
        int[][] tree = new int[N][N];
        tree[0] = new int[]{7,0,0,0,0};
        tree[1] = new int[]{3,8,0,0,0};
        tree[2] = new int[]{8,1,10,0,0};
        tree[3] = new int[]{2,7,4,4,0};
        tree[4] = new int[]{4,5,2,6,5};
        int max = recMaxSum(tree, N, 0, 0);
        int max2 = dpMaxSum(tree, N);
    }

    private static int dpMaxSum(int[][] tree, int N) {
        int[][] maxSum = new int[N][N];
        for (int m = 0; m < N; m++) {
            maxSum[N - 1][m] = tree[N - 1][m];
        }
        for (int p = N - 2; p >= 0; p--) {
            for (int q = 0; q <= p; q++) {
                maxSum[p][q] = Math.max(maxSum[p + 1][q], maxSum[p + 1][q + 1]) + tree[p][q];
            }
        }
        return maxSum[0][0];
    }

    /**
     * N:表示树一共有多少行
     * i,j表示从tree[i][j]到底部的最大路径和
     */
    private static int recMaxSum(int[][] tree, int N, int i, int j) {
        if (i == N - 1) {
            return tree[i][j];
        }
        return Math.max(recMaxSum(tree, N, i + 1, j), recMaxSum(tree, N, i + 1, j + 1)) + tree[i][j];
    }

}
