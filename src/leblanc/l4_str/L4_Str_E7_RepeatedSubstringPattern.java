package leblanc.l4_str;

/**
 * LC 459
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-24
 */
public class L4_Str_E7_RepeatedSubstringPattern {

    public static void main(String[] args) {
        L4_Str_E7_RepeatedSubstringPattern cl = new L4_Str_E7_RepeatedSubstringPattern();
        boolean bool = cl.repeatedSubstringPattern("aaabbaaabb");
    }

    public boolean repeatedSubstringPattern(String s) {
        int[] preTable = new int[s.length()];
        int j = 0;
        preTable[0] = 0;
        for (int i = 1; i < preTable.length; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = preTable[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                preTable[i] = ++j;
            }
        }
        return preTable[s.length() - 1] > 0
                && s.length() % (s.length() - preTable[s.length() - 1]) == 0;
    }
}
