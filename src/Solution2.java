public class Solution2 {
    //public ListNode temp = new ListNode();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }

    public ListNode add(ListNode l1, ListNode l2,int a) {
        ListNode temp = new ListNode();
        if(l1 == null && l2 != null){
            if (a+l2.val>=10) {
                ListNode ll1 = new ListNode(0);
                temp.next = add(ll1,l2.next,1);
            }else {
                temp.val= l2.val + a;
                temp.next = l2.next;
            }
            return temp;
        }else if(l1 != null && l2 == null){
            if (a+l1.val>=10) {
                ListNode ll2 = new ListNode(0);
                temp.next = add(l1.next,ll2,1);
            }else {
                temp.val= l1.val + a;
                temp.next = l1.next;
            }
            return temp;
        }else if(l1 == null && l2 == null && a == 0){
            return null;
        }else if(l1 == null && l2 == null && a != 0) {
            temp.val = 1;
            return temp;
        }else {
            temp.val = l1.val + l2.val +a;
            if(temp.val>=10) {
                temp.val = temp.val - 10;
                a = 1;
            }else {
                a = 0;
            }
            temp.next = add(l1.next,l2.next,a);
            return temp;
        }
    }

}

