package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            return result;
        }
        for (int i = 0;i < n;i++){//表示和第一个"("匹配的")"的位置为2*i+1
            for (String leftStr : generateParenthesis(i)){
                for (String rightStr : generateParenthesis(n - i - 1)){
                    result.add("("+leftStr+")"+rightStr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
