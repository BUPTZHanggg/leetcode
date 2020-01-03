package medium;

import common.ListNode;
import tool.LinkedListTool;

import java.util.List;

public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        //先反转
        ListNode previous = null;
        ListNode curr = head;
        while (curr.next != null){
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        curr.next = previous;
        //反转完成
        //====================
        int index = 1;
        ListNode previous2 = null;
        ListNode curr2 = curr;
        while (curr2 != null){
            if (index != n){
                ListNode next = curr2.next;
                curr2.next = previous2;
                previous2 = curr2;
                curr2 = next;
            }else {
                curr2 = curr2.next;
            }
            index++;
        }
        return previous2;
    }

    public static void main(String[] args) {
        ListNode offer = LinkedListTool.offer(1);
        LinkedListTool.print(offer);
        LinkedListTool.print(removeNthFromEnd(offer, 1));
    }
}
