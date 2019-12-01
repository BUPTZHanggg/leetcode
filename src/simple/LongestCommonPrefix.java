package simple;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int index = 0;
        while (true){
            if (!(strs[0].length() > index)){
                return strs[0].substring(0,index);
            }
            char tmp = strs[0].charAt(index);
            for (String s : strs){
                if (index == s.length() || s.charAt(index) != tmp){
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"ab","abc","aa","cd"};
        System.out.println(longestCommonPrefix(strs));
    }
}
