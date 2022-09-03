package leblanc.l2_linkedlist;

import common.ListNode;
import tool.LinkedListTool;

/**
 * LC19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-06
 */
public class L2_LinkedList_E4_RemoveNthFromEnd {

    public static void main(String[] args) {
        L2_LinkedList_E4_RemoveNthFromEnd cl = new L2_LinkedList_E4_RemoveNthFromEnd();
        ListNode offer = LinkedListTool.offerSorted(5);
        LinkedListTool.print(offer);
        LinkedListTool.print(cl.removeNthFromEnd(offer, 6));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (n >= 0) {
            //移动n + 1
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return dummy.next;
    }
}
