package leblanc;

import common.ListNode;
import tool.LinkedListTool;

/**
 * LC203
 * 给你一个链表的头节点 head 和一个整数 val
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-01
 */
public class L2_LinkedList_E1_RemoveElements {

    public static void main(String[] args) {
        ListNode node = LinkedListTool.offerSorted(10);
        LinkedListTool.print(node);
        L2_LinkedList_E1_RemoveElements cl = new L2_LinkedList_E1_RemoveElements();
        ListNode node1 = cl.removeElements(node, 10);
        LinkedListTool.print(node1);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
