package leblanc;

import java.util.Stack;

/**
 * LC20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-27
 */
public class L5_StackAndQueue_E3_ValidBrackets {

    public static void main(String[] args) {
        L5_StackAndQueue_E3_ValidBrackets cl = new L5_StackAndQueue_E3_ValidBrackets();
        System.out.println(cl.isValid("((){}){}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
