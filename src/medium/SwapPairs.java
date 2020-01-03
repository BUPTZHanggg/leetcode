package medium;

import common.ListNode;
import tool.LinkedListTool;

public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;
        }else {
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = LinkedListTool.offer(5);
        LinkedListTool.print(n1);
        LinkedListTool.print(swapPairs(n1));
    }
}
