package hard;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;
        boolean firstMatch = false;
        if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
            firstMatch = true;
        if (p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
        }else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a","a*"));
    }
}
