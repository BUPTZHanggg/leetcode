package jzOffer;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-27
 *
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    public String replaceSpace (String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        int spaceCnt = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                spaceCnt++;
            }
        }
        char[] chars = new char[s.length() + spaceCnt * 2];
        int p = len - 1;
        int q = chars.length - 1;
        for (int i = 0; i <= p; i++) {
            chars[i] = s.charAt(i);
        }
        while (q > p) {
            if (chars[p] == ' ') {
                chars[q--] = '0';
                chars[q--] = '2';
                chars[q--] = '%';
                p--;
            } else {
                chars[q--] = chars[p--];
            }
        }
        return new String(chars);
    }
}
