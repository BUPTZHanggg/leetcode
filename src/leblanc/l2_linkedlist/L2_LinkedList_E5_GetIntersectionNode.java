package leblanc;

import common.ListNode;

/**
 * LC 面试题02.07
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 * 题目数据 保证 整个链式结构中不存在环
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2022-06-07
 */
public class L2_LinkedList_E5_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA, head2 = headB;
        while (headA != headB) {
            headA = headA == null ? head2 : headA.next;
            headB = headB == null ? head1 : headB.next;
        }
        return headA;
    }
}
