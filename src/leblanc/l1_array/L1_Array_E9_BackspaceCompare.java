package leblanc;

/**
 * LC844
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。
 * # 代表退格字符。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-05-02
 */
public class L1_Array_E9_BackspaceCompare {

    public static void main(String[] args) {
        L1_Array_E9_BackspaceCompare cl = new L1_Array_E9_BackspaceCompare();
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(cl.backspaceCompare(s, t));
    }

    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int lenS = validLen(sChars);
        int lenT = validLen(tChars);
        if (lenS != lenT) return false;
        for (int i = 0; i < lenS; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }

    //返回处理退格字符后的长度
    private int validLen(char[] str) {
        if (str == null || str.length == 0) {
            return 0;
        }
        int slowIndex = 0, fastIndex = 0;
        for (; fastIndex < str.length; fastIndex++) {
            if (str[fastIndex] == '#') {
                if (slowIndex > 0) {
                    slowIndex--;
                }
            } else {
                str[slowIndex++] = str[fastIndex];
            }
        }
        return slowIndex;
    }
}
