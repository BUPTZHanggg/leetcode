package leblanc.l1_array;

/**
 * LC76
 * 给你一个字符串 s 、一个字符串 t (由英文字母组成)。
 * 返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *  如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-11
 */
public class L1_Array_E13_MinWindow {


    public static void main(String[] args) {
        L1_Array_E13_MinWindow cl = new L1_Array_E13_MinWindow();
        String s = "aaadvsfew";
        String t = "ava";
        System.out.println(cl.minWindow(s, t));
        cl.minWindow(s, t);
    }

    //A-Z 65-90
    //a-z 97-122
    public String minWindow(String s, String t) {
        int[] charCounts = new int[123]; //存放t中还未匹配到的各字符数量
        boolean[] flag = new boolean[123];
        for (int i = 0; i < t.length(); i++) {
            int currIndex = t.charAt(i);
            flag[currIndex] = true;
            ++charCounts[currIndex];
        }
        int l = 0, resL = 0, resSize = s.length() + 1;
        int matchCnt = 0; //已匹配到t中字符的数量
        for (int r = 0; r < s.length(); r++) {
            int currIndex = s.charAt(r);
            if (flag[currIndex]) { //当前字符在t中
                if (--charCounts[currIndex] >= 0) {
                    matchCnt++;
                }
                while (matchCnt == t.length()) {
                    if (r - l + 1 < resSize) {
                        resSize = r - l + 1;
                        resL = l;
                    }
                    int lIndex = s.charAt(l++);
                    if (flag[lIndex] && ++charCounts[lIndex] > 0) {
                        matchCnt--;
                    }
                }
            }
        }
        return resSize > s.length() ? "" : s.substring(resL, resL + resSize);
    }
}
