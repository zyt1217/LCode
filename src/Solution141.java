public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        if(p2 == null)
            return false;
        while(p2 != p1){
            p1 = p1.next;
            if(p2.next == null)
                return false;
            if(p2.next.next==null)
                return false;
            p2 = p2.next.next;
        }
        return true;
    }
}
