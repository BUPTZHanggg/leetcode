package medium;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
//        Map<Integer, Integer> flag = new HashMap<>();//用于判断是否重复
        for (int i=0; i<nums.length; i++) {
            int j=i+1, k=nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==0) {
//                    if (flag.containsKey(nums[i]) && flag.get(nums[i]).equals(nums[k])){
//                        j++;
//                        continue;//已经存在了
//                    }
                    List<Integer> item = new ArrayList();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    result.add(item);
                    j++;
//                    flag.put(nums[i],nums[k]);
                } else if (sum>0) k--;
                else j++;
            }
        }
        return new ArrayList(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
        Set<List<Integer>> result = new HashSet();
        List<Integer> list = Arrays.asList(1,2,3);
        result.add(list);

    }

}
