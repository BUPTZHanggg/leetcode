package step1;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-06
 */
public class S1_Array_E1_P485_MaxConsecutiveOnes {

    public static void main(String[] args) {
        S1_Array_E1_P485_MaxConsecutiveOnes p485 = new S1_Array_E1_P485_MaxConsecutiveOnes();
        System.out.println(p485.findMaxConsecutiveOnes(new int[]{1,1,0,0,1,1,1}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int currCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currCount++;
            } else {
                res = Math.max(res, currCount);
                currCount = 0;
            }
        }
        return Math.max(res, currCount);
    }
}
