package LinkedList;
import preDefine.ListNode;

public class Solution206_reverse_vhead_3p {
    public ListNode reverseList(ListNode head) {
        //三指针 虚拟头节点
        if(head == null || head.next == null)
            return head;
        ListNode vhead = new ListNode();
        vhead.next = head;
        ListNode p1 = vhead;
        ListNode p2 = vhead.next;
        ListNode p3 = p2.next;
        while (p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head.next = null;
        return p2;
    }
}
