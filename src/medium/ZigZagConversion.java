package medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows <= 1)
            return s;
        int currRow = 0;//当前行
        boolean ifDown = false;//是否向下
        List<StringBuilder> list = new ArrayList<>();
        int loopNum = s.length() > numRows ? numRows : s.length();//list的行数
        for (int i = 0;i < loopNum;i++){
            list.add(new StringBuilder());
        }
        for (char c : s.toCharArray()){
            list.get(currRow).append(c);
            if (currRow == numRows - 1 || currRow == 0){
                ifDown = !ifDown;
            }
            currRow += ifDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list){
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("abcdc", 3));
    }
}
