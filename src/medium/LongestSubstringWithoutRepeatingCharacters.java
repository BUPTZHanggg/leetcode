package medium;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int tmpLen = 0;//每次循环的长度
        int result = 0;//记录最长的字串长度
        int beginIndex = 0;
        for (int i = 0;i < s.length();i++){
            String tmpStr = s.substring(beginIndex, i);
            int indexTmp = tmpStr.indexOf(s.charAt(i));
            if (indexTmp ==  -1){//说明该char在这一次的长度叠加中第一次出现
                tmpLen++;
                if (tmpLen > result){
                    result = tmpLen;
                }
            }else {
                beginIndex = indexTmp + 1 + beginIndex;
                if (tmpLen > result){
                    result = tmpLen;
                }
                tmpLen = i - beginIndex + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbaddfghj"));
    }
}
