package medium;

/**
 * 遍历字符串  从中间向两边扩展
 */
public class P5LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int currLen = Math.max(len1, len2);
            if (currLen > maxLen) {
                maxLen = currLen;
                left = i - (currLen - 1) / 2;
                right = i + currLen / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public static int expand(String s, int index1, int index2) {
        while (index1 >= 0 && index2 <= s.length() - 1 && s.charAt(index1) == s.charAt(index2)) {
            index1--;
            index2++;
        }
        return index2 - index1 - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}


