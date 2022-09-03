package leblanc;

import common.ListNode;

/**
 * LC142
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 不允许修改 链表。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-09
 */
public class L2_LinkedList_E6_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null) return null; //无环
        while (fast != head) {
            head = head.next;
            fast = fast.next;
        }
        return head;
    }

}
