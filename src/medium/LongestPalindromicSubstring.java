package medium;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int startIndex = 0;
        int endIndex = s.length() - 1;
        int longestLength = 0;
        for (int i = 0, j = s.length() - 1;i <= j;i++,j--) {
            for (int m = i;j - m + 1 > longestLength;m++){
                if (isPalindrome(s,m,j)){
                    startIndex = m;
                    endIndex = j;
                    longestLength = j - m + 1;
                    break;
                }
            }
            for (int m = s.length() - 1;m - i + 1 > longestLength;m--){
                if (isPalindrome(s, i, m)){
                    startIndex = i;
                    endIndex = m;
                    longestLength = m - i + 1;
                    break;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public static boolean isPalindrome(String s, int startIndex, int endIndex){
        if (startIndex == endIndex)
            return true;
        if (s.charAt(endIndex) == s.charAt(startIndex)){
            if (endIndex - startIndex == 1)
                return true;
            return isPalindrome(s, startIndex + 1, endIndex - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ebb"));
    }
}


