public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode Node1 = head;
        ListNode Node2 = head;
        for(int i = 0; i< n;i++)
            Node1 = Node1.next;
        if(Node1 == null)
            return head.next;
        while (Node1.next != null){
            Node1 = Node1.next;
            Node2 = Node2.next;
        }
        ListNode temp = Node2.next;
        Node2.next = temp.next;
        temp.next = null;
        return head;

    }
}
/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 */