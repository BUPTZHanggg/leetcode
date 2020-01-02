package medium;

import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0;i < nums.length - 3;i++){
            for (int j = i + 1;j < nums.length - 2;j++){
                int head = j + 1;
                int tail = nums.length - 1;
                int tmpTarget = target - nums[i] - nums[j];
                while (head < tail){
                    int tmpSum = nums[head] + nums[tail];
                    if (tmpSum == tmpTarget){
                        set.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                    }
                    if (tmpSum > tmpTarget){
                        tail--;
                    }else {
                        head++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }

}
