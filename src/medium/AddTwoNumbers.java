package medium;

import common.ListNode;
import tool.LinkedListTool;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        boolean lenFlag = true;//判断l1是否长度大于等于l2
        boolean valFlag = false;//判断是否需要进位
        while (l1 != null || l2 != null) {
            boolean l1Null;
            boolean l1NextNull;
            int valSum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            if (valFlag) {
                valSum++;
            }
            if (valSum >= 10) {
                valSum -= 10;
                valFlag = true;
            } else {
                valFlag = false;
            }
            if (l1 != null) {
                l1Null = false;
                l1NextNull = (l1.next == null);
                l1.val = valSum;
                if (l1.next == null && (l2 == null || l2.next == null) && valFlag) {//用于处理最后一位需要进位的情况
                    l1.next = new ListNode(1);
                    break;
                } else {
                    l1 = l1.next;
                }
            } else {
                l1Null = true;
                l1NextNull = true;
                lenFlag = false;
            }
            if (l2 != null) {
                l2.val = valSum;
                if (l2.next == null && (l1Null || l1NextNull) && valFlag) {//用于处理最后一位需要进位的情况
                    l2.next = new ListNode(1);
                    break;
                } else {
                    l2 = l2.next;
                }
            }
        }
        if (lenFlag) {
            return curr1;
        } else {
            return curr2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.offer(5);
        LinkedListTool.print(l1);
        ListNode l2 = LinkedListTool.offer(4);
        LinkedListTool.print(l2);
        LinkedListTool.print(addTwoNumbers(l1, l2));
    }

}



