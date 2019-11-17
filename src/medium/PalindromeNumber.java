package medium;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;//负数一定不可以
        int originNum = x;
        int inverseNum = 0;//记录倒序数值
        while (x != 0){
            int tmp = x % 10;
            inverseNum = inverseNum * 10 + tmp;
            x = x / 10;
        }
        return inverseNum == originNum;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1217));
    }
}
