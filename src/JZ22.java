import java.util.LinkedList;
import java.util.Queue;

public class JZ22 {
    int i = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for(int i = 0; i<k; i++)
        latter = latter.next;
        while (latter !=null){
            former = former.next;
            latter = latter.next;
        }
        return former;
    }
}
