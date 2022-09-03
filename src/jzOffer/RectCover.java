package jzOffer;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-23
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？
 */
public class RectCover {

    public int rec_rectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else if (target == 0) {
            return 0;
        }
        return rec_rectCover(target - 1) + rec_rectCover(target - 2);
    }

    public int dp_rectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else if (target == 0) {
            return 0;
        }
        int[] res = new int[target + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3;i <= target; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target];
    }
}
