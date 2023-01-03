package test;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-12-03
 */
public class StringTest {
    public static void main(String[] args) {
        String s = String.valueOf(100);
        s.intern();
        String t = "100";
        System.out.println(s == t);
    }
}
