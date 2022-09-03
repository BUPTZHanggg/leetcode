package leblanc.l1_array;

/**
 * LC59
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-24
 */
public class L1_Array_E14_GenerateMatrix {

    public static void main(String[] args) {
        L1_Array_E14_GenerateMatrix cl = new L1_Array_E14_GenerateMatrix();
        int[][] ints = cl.generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loopNum = n / 2; //循环次数
        int startX = 0, startY = 0, offset = 1;
        int count = 0;
        while (loopNum > 0) {
            int i = startX, j = startY;
            //左 -> 右
            for (; j < n - offset; j++) {
                res[startX][j] = ++count;
            }
            //上 -> 下
            for (; i < n - offset; i++) {
                res[i][j] = ++count;
            }
            //右 -> 左
            for (; j > startY; j--) {
                res[i][j] = ++count;
            }
            //下 -> 上
            for (; i > startX; i--) {
                res[i][j] = ++count;
            }
            loopNum--;
            startX++;
            startY++;
            offset++;
        }
        if (n % 2 != 0) {
            res[startX][startY] = ++count;
        }
        return res;
    }
}
