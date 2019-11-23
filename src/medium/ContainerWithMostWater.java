package medium;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0,j = height.length - 1;i < j;){
            int tmp = Math.min(height[i],height[j]) * (j - i);
            if (tmp > result)
                result = tmp;
            if (height[i] == height[j]){
                j--;
            }else {
                i++;
            }
        }
        return result;
    }
}
