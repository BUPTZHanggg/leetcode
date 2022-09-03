package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 1 <= n <= 8
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-02-18
 */
public class BackTrace_P22_GenerateParenthesis {

    public static void main(String[] args) {
        BackTrace_P22_GenerateParenthesis p22 = new BackTrace_P22_GenerateParenthesis();
        List<String> list = p22.generateParenthesis(3);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n, 0, 0, res, "");
        return res;
    }

    public void generateParenthesis(int n, int left, int right, List<String> res, String str) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (right > left) {
            return;
        }
        if (left < n) {
            generateParenthesis(n, left + 1, right, res, str + "(");
        }
        if (right < n) {
            generateParenthesis(n, left, right + 1, res, str + ")");
        }
    }
}
