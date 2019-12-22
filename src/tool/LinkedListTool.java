package tool;

import common.ListNode;

public class LinkedListTool {

    /**
     * 打印链表
     * @param listNode
     */
    public static void print(ListNode listNode){
        StringBuilder sb = new StringBuilder();
        while (listNode != null){
            sb.append(listNode.getVal());
            if (listNode.getNext() != null){
                sb.append("->");
            }
            listNode = listNode.getNext();
        }
        System.out.println(sb.toString());
    }

    /**
     * 生成长度为length的随机数链表
     * @param length
     * @return
     */
    public static ListNode offer(int length){
        if (length == 1)
            return new ListNode((int)(Math.random() * 10));
        ListNode result = new ListNode((int)(Math.random() * 10));
        result.setNext(offer(length - 1));
        return result;
    }

    /**
     * 生成长度为length的有序链表
     * @param length
     * @return
     */
    public static ListNode offerSorted(int length){
        if (length == 1)
            return new ListNode(10-length);
        ListNode result = new ListNode(10-length);
        result.setNext(offerSorted(length - 1));
        return result;
    }
}
