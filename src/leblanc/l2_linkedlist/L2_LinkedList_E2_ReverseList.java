package leblanc.l2_linkedlist;

import common.ListNode;
import tool.LinkedListTool;

/**
 * LC206
 * 翻转链表
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-03
 */
public class L2_LinkedList_E2_ReverseList {

    public static void main(String[] args) {
        L2_LinkedList_E2_ReverseList cl = new L2_LinkedList_E2_ReverseList();
        ListNode offer = LinkedListTool.offer(5);
        LinkedListTool.print(offer);
        LinkedListTool.print(cl.reverseList(offer));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
