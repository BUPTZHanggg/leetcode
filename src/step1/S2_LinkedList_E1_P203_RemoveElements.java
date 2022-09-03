package step1;

import common.ListNode;
import tool.LinkedListTool;

/**
 * 给你一个链表的头节点 head 和一个整数 val
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-03-20
 */
public class S2_LinkedList_E1_P203_RemoveElements {

    public static void main(String[] args) {
        ListNode node = LinkedListTool.offerSorted(2);
        LinkedListTool.print(node);
        S2_LinkedList_E1_P203_RemoveElements s2 = new S2_LinkedList_E1_P203_RemoveElements();
        ListNode node1 = s2.removeElements(node, 9);
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
