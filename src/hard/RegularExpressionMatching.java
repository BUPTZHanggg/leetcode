package hard;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int sIndex = 0;
        for (int i = 0;i < p.length();i++){
            if (sIndex >= s.length())
                return false;
            if (p.charAt(i) == '.'){
                if (isMatch(s.substring(sIndex),p.substring(i + 1)))
                    return true;
            }
        }
        if (sIndex < s.length())
            return false;
        return true;
    }
}
