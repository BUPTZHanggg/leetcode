package leblanc.l5_stackAndQueue;

import java.util.Stack;

/**
 * LC150
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意 两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 提示：
 *
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 *  
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 *
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-08-12
 */
public class L5_StackAndQueue_E5_EvalRPN {

    public static void main(String[] args) {
        String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        L5_StackAndQueue_E5_EvalRPN cl = new L5_StackAndQueue_E5_EvalRPN();
        System.out.println(cl.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("-")) {
                stack.push((stack.pop() - stack.pop()) * -1);
            } else if (str.equals("/")) {
                Integer n1 = stack.pop();
                Integer n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
