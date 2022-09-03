package jzOffer;

import java.util.List;

import common.ListNode;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-11-21
 */
public class LB_FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (pHead1 != pHead2) {
            pHead1 = pHead1 == null ? p2 : pHead1.next;
            pHead2 = pHead2 == null ? p1 : pHead2.next;
        }
        return pHead1;
    }
    
}
