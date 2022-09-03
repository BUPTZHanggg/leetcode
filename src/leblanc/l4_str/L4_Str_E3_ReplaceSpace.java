package leblanc.l4_str;

/**
 * JZ05
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-07
 */
public class L4_Str_E3_ReplaceSpace {

    public static void main(String[] args) {
        L4_Str_E3_ReplaceSpace cl = new L4_Str_E3_ReplaceSpace();
        System.out.println(cl.replaceSpace(" a "));
    }

    public String replaceSpace(String s) {
        int extraLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                extraLen += 2;
            }
        }
        if (extraLen == 0) {
            return s;
        }
        s += new String(new char[extraLen]);
        char[] chars = s.toCharArray();
        int left = s.length() - 1 - extraLen, right = s.length() - 1;
        while (left < right) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
                left--;
            } else {
                chars[right--] = chars[left--];
            }
        }
        return new String(chars);
    }
}
