package medium;

import common.ListNode;
import tool.LinkedListTool;

/**
 * 哑结点用于最后返回
 * 一个int值记录进位
 */
public class P2AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        int step = 0;
        while (l1 != null || l2 != null){
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);
            int currVal = val1 + val2 + step;
            step = currVal / 10;
            curr = curr.next = new ListNode(currVal % 10);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (step == 1)
            curr.next = new ListNode(1);
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.offer(5);
        LinkedListTool.print(l1);
        ListNode l2 = LinkedListTool.offer(4);
        LinkedListTool.print(l2);
        LinkedListTool.print(addTwoNumbers(l1, l2));
    }

}



