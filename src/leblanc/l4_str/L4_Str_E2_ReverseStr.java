package leblanc.l4_str;

/**
 * LC54
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-06
 */
public class L4_Str_E2_ReverseStr {

    public static void main(String[] args) {
        L4_Str_E2_ReverseStr cl = new L4_Str_E2_ReverseStr();
        System.out.println(cl.reverseStr0("abcdefg", 2));
    }

    public String reverseStr0(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int left = i, right = left + k <= s.length() ? left + k - 1 : s.length() - 1;
            while (left < right) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left++;
                right--;
            }
            i += (2 * k);
        }
        return new String(chars);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0;i < s.length(); i += 2 * k) {
            int left = i, right = Math.min(left + k - 1, chars.length - 1);
            while (left < right) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
