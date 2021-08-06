import preDefine.ListNode;

public class JZ25_Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        if(l1.val>l2.val){
            head = l2;
            l2 = l2.next;
        }else {
            head = l1;
            l1 = l1.next;
        }
        head.next = mergeTwoLists(l1,l2);
        return head;
    }
}
