package leblanc;

/**
 * JZ58
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 1 <= k < s.length <= 10000
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-18
 */
public class L4_Str_E5_ReverseLeftWords {

    public static void main(String[] args) {
        L4_Str_E5_ReverseLeftWords cl = new L4_Str_E5_ReverseLeftWords();
        String aawdvawqr = cl.reverseLeftWords("aawdvawqr", 9);
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) return s;
        n = Math.min(n, s.length());
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverse(chars, 0, s.length() - n - 1);
        reverse(chars, s.length() - n, s.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }
}
