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
        int max = recMaxSum(tree, 0, 0);
        int max2 = dpMaxSum1(tree, N);
    }


    /**
     * i,j表示从tree[i][j]到底部的最大路径和
     */
    private static int recMaxSum(int[][] tree, int i, int j) {
        if (i == tree.length - 1) {
            return tree[i][j];
        }
        int A = recMaxSum(tree, i + 1, j);
        int B = recMaxSum(tree, i + 1, j + 1);
        return tree[i][j] + Math.max(A, B);
    }
    private static int dpMaxSum1(int[][] tree, int N) {
        int[][] res = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            res[N - 1][i] = tree[N - 1][i];
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int A = res[i + 1][j];
                int B = res[i + 1][j + 1];
                res[i][j] = Math.max(A, B) + tree[i][j];
            }
        }
        return res[0][0];
    }

}
