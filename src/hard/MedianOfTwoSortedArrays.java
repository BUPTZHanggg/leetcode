package hard;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int longLen = nums1.length;
        int shortLen = nums2.length;
        int[] longOne = nums1;
        int[] shortOne = nums2;
        if (nums1.length < nums2.length){//区别二者的长度
            longOne = nums2;
            shortOne = nums1;
            longLen = nums2.length;
            shortLen = nums1.length;
        }
        if (shortLen == 0){
            if (longLen % 2 == 0){
                return (longOne[longLen / 2] + longOne[longLen / 2 - 1]) / 2.0;
            }else {
                return longOne[longLen / 2];
            }
        }
        //对特殊情况进行分析
        //情况1 短数组整体被划分到右侧
        int spIndex1 = (longLen + shortLen + 1) / 2;
        if (shortOne[0] >= longOne[spIndex1 - 1]){
            if ((shortLen + longLen) % 2 == 0){
                if (spIndex1 == longLen){//此时代表长数组同时整体被分到了左侧
                    return (shortOne[0] + longOne[spIndex1 - 1]) / 2.0;
                }
                int tmp = shortOne[0] < longOne[spIndex1] ? shortOne[0] : longOne[spIndex1];//取出右侧最小的那个
                return (tmp + longOne[spIndex1 - 1]) / 2.0;
            }
            return longOne[spIndex1 - 1];
        }
        //情况2  短数组整体被划分到左侧
        int spIndex2 = (longLen - shortLen + 1) / 2;
        if (shortOne[shortLen - 1] <= longOne[spIndex2]){
            if (shortLen == longLen){//此时代表长数组同时整体分到了右侧
               return (shortOne[shortLen - 1] + longOne[0]) / 2.0;
            }
            int tmp = shortOne[shortLen - 1] > longOne[spIndex2 - 1] ? shortOne[shortLen - 1] : longOne[spIndex2 - 1];//去除左侧最大的那个
            if ((shortLen + longLen) % 2 == 0){
                return (tmp + longOne[spIndex2]) / 2.0;
            }
            return tmp;
        }
        //分析一般情况 即两个数组都分在了两侧
        for (int i = 1;i < shortOne.length;i++){//i和j分别代表短长数组的index
            int normalIndex = (longLen + shortLen + 1) / 2 - i;
            if (shortOne[i - 1] <= longOne[normalIndex] && shortOne[i] >= longOne[normalIndex - 1]){
                int leftTmp = shortOne[i - 1] > longOne[normalIndex - 1] ? shortOne[i - 1] : longOne[normalIndex - 1];//左侧取最大
                int rightTmp = shortOne[i] < longOne[normalIndex] ? shortOne[i] : longOne[normalIndex];//右侧取最小
                if ((shortLen + longLen) % 2 == 0){
                    return (leftTmp + rightTmp) / 2.0;
                }
                return leftTmp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {1};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
