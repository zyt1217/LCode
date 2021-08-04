package linkedList.virtualHead;


import linkedList.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode vhead = new ListNode();
        vhead.next = head;
        ListNode pre = vhead;
        while (head != null){
            if(head.val == val){
                pre.next = head.next;
                head = head.next;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return vhead.next;
    }
}
