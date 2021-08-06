package linkedList;

import preDefine.ListNode;

public class Solution142_2p_findCycleEnter {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null)
            return null;
        ListNode index = head;
        while (index != fast){
            fast = fast.next;
            index = index.next;
        }
        return index;
    }
}
