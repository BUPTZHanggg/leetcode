package hard;

import common.ListNode;
import tool.LinkedListTool;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        int minVal = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0;i < lists.length;i++){
            if (lists[i] != null && lists[i].val < minVal){
                index = i;
                minVal = lists[i].val;
            }
        }
        if (index == -1){
            return null;
        }else {
            ListNode node = new ListNode(lists[index].val);
            lists[index] = lists[index].next;
            node.next = mergeKLists(lists);
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = LinkedListTool.offerSorted(3);
        LinkedListTool.print(n1);
        ListNode n2 = LinkedListTool.offerSorted(2);
        LinkedListTool.print(n2);
        ListNode n3 = LinkedListTool.offerSorted(2);
        LinkedListTool.print(n3);
        LinkedListTool.print(mergeKLists(new ListNode[]{n1,n2,n3}));
    }
}
