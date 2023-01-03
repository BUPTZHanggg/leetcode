package jzOffer;

import java.util.concurrent.locks.ReentrantLock;

import common.ListNode;

/**
 * 输入一个长度为 n 的链表 ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-12-06
 */
public class LB_FindKthToTail {
    ReentrantLock reentrantLock = new ReentrantLock(true);
    int a = 5;

    public static void main(String[] args) {

    }

    private void m() {
        try {
            reentrantLock.lock();
            //业务
            a++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (k > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
