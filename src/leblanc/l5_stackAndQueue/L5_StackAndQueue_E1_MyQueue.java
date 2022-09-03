package leblanc;

import java.util.Stack;

/**
 * LC232
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-07-25
 */
public class L5_StackAndQueue_E1_MyQueue {

    public static void main(String[] args) {
        L5_StackAndQueue_E1_MyQueue myQueue = new L5_StackAndQueue_E1_MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek();// return 1
        int pop = myQueue.pop();// return 1, queue is [2]
        myQueue.push(4);
        boolean empty = myQueue.empty();// return false
    }

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public L5_StackAndQueue_E1_MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
