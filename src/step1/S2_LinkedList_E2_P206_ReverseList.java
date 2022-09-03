package step1;

import common.ListNode;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-21
 */
public class S2_LinkedList_E2_P206_ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
