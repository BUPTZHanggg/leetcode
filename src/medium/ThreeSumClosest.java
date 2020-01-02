package medium;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int check = Math.abs(result - target);
        for (int i = 0;i < nums.length - 2;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int tmpSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(tmpSum - target) < check){
                    check = Math.abs(tmpSum - target);
                    result = tmpSum;
                }
                if (tmpSum > target){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return result;

    }
}
