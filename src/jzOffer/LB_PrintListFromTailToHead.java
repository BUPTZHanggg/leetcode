package jzOffer;

import java.util.ArrayList;
import java.util.Stack;

import common.ListNode;
import tool.LinkedListTool;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-28
 *
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）
 */
public class LB_PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

}
