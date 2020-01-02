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
        LinkedListTool.offer(2);
    }
}
