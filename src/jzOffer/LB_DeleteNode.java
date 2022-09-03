package jzOffer;

import common.ListNode;
import tool.LinkedListTool;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-12-26
 */
public class LB_DeleteNode {

    public static ListNode deleteNode1(ListNode head, int val) {
        ListNode track = new ListNode(-1);
        track.next = head;
        ListNode curr = head;
        ListNode prev = track;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                return track.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return track.next;
    }

    public static void main(String[] args) {
        ListNode offer = LinkedListTool.offerSorted(2);
        LinkedListTool.print(offer);
        ListNode node = deleteNode1(offer, 8);
        LinkedListTool.print(node);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (head != null) {
            if (head.val == val) {
                curr.next = head.next;
                break;
            } else {
                head = head.next;
                curr = curr.next;
            }
        }
        return pre.next;
    }
}
