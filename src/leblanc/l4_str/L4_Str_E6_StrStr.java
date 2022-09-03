package leblanc.l4_str;

import java.util.Arrays;

/**
 * LC28
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）
 * 如果不存在，则返回  -1 。
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-20
 */
public class L4_Str_E6_StrStr {

    public static void main(String[] args) {
        L4_Str_E6_StrStr cl = new L4_Str_E6_StrStr();
        String a = "hello";
        String s = "llnu";
        int[] nextArr = new int[s.length()];
        cl.buildPreTable(nextArr, s.toCharArray());
        System.out.println(Arrays.toString(nextArr));
        System.out.println(cl.strStr(a, s));
    }

    public int strStr(String haystack, String needle) {
        int[] preTable = new int[needle.length()]; //前缀表
        buildPreTable(preTable, needle.toCharArray());
        int i = 0, j = 0;
        while (i < needle.length() && j < haystack.length()) {
            while (i > 0 && needle.charAt(i) != haystack.charAt(j)) {
                i = preTable[i - 1];
            }
            if (needle.charAt(i) == haystack.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == needle.length() ? j - needle.length() : -1;
    }

    //构造前缀表
    private void buildPreTable(int[] preTable, char[] str) {
        int preEnd = 0;
        preTable[preEnd] = 0;
        for (int sufEnd  = 1; sufEnd < str.length; sufEnd++) {
            while (preEnd > 0 && str[preEnd] != str[sufEnd]) {
                preEnd = preTable[preEnd - 1];
            }
            if (str[preEnd] == str[sufEnd]) {
                preEnd++;
            }
            preTable[sufEnd] = preEnd;
        }
    }
}
