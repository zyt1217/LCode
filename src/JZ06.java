import java.util.ArrayList;

public class JZ06 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (head != null){
            temp.add(head.val);
            head = head.next;
        }
        int[] ans = new int[temp.size()];
        for(int i = temp.size()-1;i>=0;i--){
            ans[i] = temp.get(temp.size()-1-i);
        }
        return ans;
    }
}
