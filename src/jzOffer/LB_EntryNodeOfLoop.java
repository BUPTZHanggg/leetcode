package jzOffer;

import common.ListNode;

/**
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-12-03
 */
public class LB_EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p2 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
