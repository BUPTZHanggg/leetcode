package jzOffer;

import java.util.List;

import common.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-12-25
 */
public class LB_DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode p = pHead;
        ListNode trick = new ListNode(-1);
        trick.next = pHead;
        ListNode last = trick;
        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                last.next = p; //在last指针未更新前 更新last.next就是更新trick.next
            } else {
                last = p; //走到这里说明p不是重复元素 并且trick.next已经改为p 这是更新last 后面更新last.next时trick.next就不会再变了
                p = p.next;
            }
        }
        return trick.next;
    }

    public ListNode deleteDuplication_rec(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        while (pHead != null) {
            if (pHead.next != null && pHead.val == pHead.next.val) {
                int val = pHead.val;
                while (pHead != null && pHead.val == val) {
                    pHead = pHead.next;
                }
            } else {
                pHead.next = deleteDuplication_rec(pHead.next);
                return pHead;
            }
        }
        return null;
    }
}
