package leblanc.l2_linkedlist;

import common.ListNode;
import tool.LinkedListTool;

/**
 * LC24
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-03
 */
public class L2_LinkedList_E3_SwapPairs {

    public static void main(String[] args) {
        ListNode offer = LinkedListTool.offer(1);
        LinkedListTool.print(offer);
        L2_LinkedList_E3_SwapPairs cl = new L2_LinkedList_E3_SwapPairs();
        LinkedListTool.print(cl.swapPairs(offer));

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (curr != null && curr.next != null) {
            ListNode pair = curr.next;
            ListNode next = pair.next;
            prev.next = pair;
            pair.next = curr;
            curr.next = next;
            prev = curr;
            curr = next;
        }
        return dummy.next;
    }
}
