package leblanc;

import java.util.ArrayList;
import java.util.List;

/**
 * LC54 & JZ29
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-26
 */
public class L1_Array_E15_SpiralOrder {

    public static void main(String[] args) {
        L1_Array_E15_SpiralOrder cl = new L1_Array_E15_SpiralOrder();
        int[][] a = new int[][]{{1,2,3,4,5}};
        System.out.println(cl.spiralOrder(a));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int loop = Math.min(m / 2, n / 2);
        int startX = 0, startY = 0, offset = 1;
        while (loop > 0) {
            int i = startX, j = startY;
            //左 -> 右
            for (; j < n - offset; j++) {
                res.add(matrix[i][j]);
            }
            //上 -> 下
            for (; i < m - offset; i++) {
                res.add(matrix[i][j]);
            }
            //右 -> 左
            for (; j > startY; j--) {
                res.add(matrix[i][j]);
            }
            //下 -> 上
            for (; i > startX; i--) {
                res.add(matrix[i][j]);
            }
            loop--;
            startX++;
            startY++;
            offset++;
        }
        for (int i = startX; i <= m - offset; i++) {
            for (int j = startY; j <= n - offset; j++) {
                res.add(matrix[i][j]);
            }
        }
        return res;
    }
}
