package jzOffer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-12-11
 */
public class LB_ComplexClone {

    public static void main(String[] args) {
        RandomListNode clone = Clone(new RandomListNode(1));
        System.out.println(clone);
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode curr0 = new RandomListNode(curr.label);
            RandomListNode next = curr.next;
            curr.next = curr0;
            curr0.next = next;
            curr = next;
        }
        curr = pHead;
        while (curr != null) {
            RandomListNode random = curr.random;
            curr.next.random = random != null ? random.next : null;
            curr = curr.next.next;
        }
        curr = pHead;
        RandomListNode res = pHead.next;
        while (curr != null) {
            RandomListNode curr0 = curr.next;
            RandomListNode next = curr.next.next;
            curr.next = next;
            curr0.next = next == null ? null : next.next;
            curr = next;
        }
        return res;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
