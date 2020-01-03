package simple;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null){
            return 0;
        }
        int dupCount = 0;
        for (int i = 0;i < nums.length - 1 - dupCount;){
            if (nums[i] == nums[i + 1]){
                for (int j = i + 1;j < nums.length - 1 - dupCount;j++){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
                dupCount++;
            }else {
                i++;
            }
        }
        return nums.length - dupCount;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}
