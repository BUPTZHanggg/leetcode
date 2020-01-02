package simple;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }else {
                Character top = stack.pop();
                int dif = c - top;
                if (!(dif == 1 || dif == 2))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}[{}]((){})(){}"));
    }

}
