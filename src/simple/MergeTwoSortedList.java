package simple;

import common.ListNode;
import tool.LinkedListTool;

public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = null;
        if (l1.val < l2.val){
            result = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }else {
            result = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListTool.offerSorted(3);
        ListNode l2 = LinkedListTool.offerSorted(4);
        LinkedListTool.print(l1);
        LinkedListTool.print(l2);
        LinkedListTool.print(mergeTwoLists(l1,l2));
    }
}
