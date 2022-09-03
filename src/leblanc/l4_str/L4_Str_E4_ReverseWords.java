package leblanc;

/**
 *
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-08
 */
public class L4_Str_E4_ReverseWords {

    public static void main(String[] args) {
        L4_Str_E4_ReverseWords cl = new L4_Str_E4_ReverseWords();
        StringBuilder builder = cl.eraseExtraSpaces(" a  rule b ");
        System.out.println(builder);
        cl.reverseStr(builder, 0, builder.length() - 1);
        System.out.println(builder);
        System.out.println(cl.reverseWords(" a  rule b "));
    }

    public String reverseWords(String s) {
        StringBuilder sb = eraseExtraSpaces(s);
        reverseStr(sb, 0, sb.length() - 1);
        int left = 0;
        while (left < sb.length()) {
            int right = left;
            while (right < sb.length() && sb.charAt(right) != ' ') right++;
            reverseStr(sb, left, right - 1);
            left = right + 1;
        }
        return sb.toString();
    }

    //翻转给定字符串的给定区间内的字符
    private void reverseStr(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public StringBuilder eraseExtraSpaces(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
