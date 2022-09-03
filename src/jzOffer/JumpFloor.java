package jzOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-18
 */
public class JumpFloor {

    public int rec_jumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return rec_jumpFloor(target - 1) + rec_jumpFloor(target - 2);
        }
    }

    public int dp_jumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] res = new int[target];
        res[0] = 1; res[1] = 2;
        for (int i = 2; i < target; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target - 1];
    }

//=====================================================================================================================

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶(n为正整数)总共有多少种跳法
     * @param target
     * @return
     */
    public int rec_jumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int res = 1;
            for (int i = 1; i < target; i++) {
                res += rec_jumpFloorII(target - i);
            }
            return res;
        }
    }

    public int dp_jumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] res = new int[target + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= target; i++) {
            res[i] = 1;
            for (int j = 1; j < i; j++) {
                res[i] += res[i - j];
            }
        }
        return res[target];
    }

}
