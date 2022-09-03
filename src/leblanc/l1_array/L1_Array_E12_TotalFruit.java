package leblanc;

/**
 * LC904
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-09
 */
public class L1_Array_E12_TotalFruit {

    public static void main(String[] args) {
        L1_Array_E12_TotalFruit cl = new L1_Array_E12_TotalFruit();
        int[] a = new int[] {1,0,1,4,1,4,1,2,3};
        System.out.println(cl.totalFruit(a));
    }

    public int totalFruit(int[] fruits) {
        int res = 0;
        int i = 0;
        int bk1 = fruits[i], bk2 = fruits[i]; //1号篮子 和 2号篮子 的水果种类
        for (int j = 0;j < fruits.length;j++) {
            if (bk1 != fruits[j] && bk2 != fruits[j]) { //新种类的处理
                i = j - 1;
                bk1 = fruits[i];
                while (i >= 1 && fruits[i - 1] == bk1) {
                    i--;
                }
                bk2 = fruits[j];
            }
            res = Math.max(res, j - i + 1); //当前循环两个篮子的总数量
        }
        return res;
    }
}
