package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;
        result.add("");
        for(char c : digits.toCharArray()){
            char beginChar = 0;
            int length = 3;
            if (c == '7'){
                beginChar = 'p';
                length = 4;
            }else if (c == '9'){
                beginChar = 'w';
                length = 4;
            }
            else if (c == '8'){
                beginChar = 't';
            }else {
                beginChar = (char) ('a' + (c - '2') * 3);
            }
            result = append(result, beginChar, length);
        }
        return result;
    }

    private static List<String> append(List<String> result, char beginChar, int length) {
        List<String> res = new ArrayList<>();
        for (int i = 0;i < length;i++){
            for (String str : result){
                res.add(str + beginChar);
            }
            beginChar++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}
