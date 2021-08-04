package linkedList;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode vhead = new ListNode();
        vhead.next = head;
        ListNode p1 = vhead;
        ListNode p2 = vhead.next;
        ListNode p3 = vhead.next.next;

        while(p3.next != null && p3.next.next != null){
            p2.next = p3.next;
            p3.next = p2;
            p1.next = p3;
            p1 = p2;
            p2 = p2.next;
            p3 = p2.next;
        }
        p2.next = p3.next;
        p3.next = p2;
        p1.next = p3;
        return vhead.next;
    }
}
