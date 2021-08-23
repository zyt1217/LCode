package LinkedList;

import preDefine.ListNode;

public class Solution19_vhead_2p {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针
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
  public class preDefine.ListNode {
      int val;
      preDefine.ListNode next;
      preDefine.ListNode() {}
      preDefine.ListNode(int val) { this.val = val; }
      preDefine.ListNode(int val, preDefine.ListNode next) { this.val = val; this.next = next; }
  }
 */