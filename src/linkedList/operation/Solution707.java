package linkedList.operation;

import preDefine.ListNode;

public class Solution707 {
    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(0,10);
        linkedList.addAtIndex(0,20);
        linkedList.addAtIndex(1,30);   //链表变为1-> 2-> 3
        linkedList.get(0);            //返回2
        linkedList.deleteAtIndex(0);  //现在链表是1-> 3
        linkedList.get(0);            //返回3
    }
}

class MyLinkedList {

    ListNode root;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        //root = new preDefine.ListNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode tmp = root;
        while (index>0){
            if(tmp == null)
                return -1;
            tmp = tmp.next;
            index --;
        }
        if(tmp == null)
            return -1;
        return tmp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode vhead = new ListNode(val);
        vhead.next = root;
        root = vhead;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(root == null){
            root = new ListNode(val);
            return;
        }
        ListNode tmp = root;
        while (tmp.next !=null)
            tmp = tmp.next;
        tmp.next = new ListNode(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode vhead = new ListNode();
        vhead.next = root;
        ListNode tmp = vhead;
        while (index>0){
            if(tmp.next == null)
                return;
            tmp = tmp.next;
            index --;
        }
        ListNode node = tmp.next;
        tmp.next = new ListNode(val);
        tmp.next.next = node;
        root = vhead.next;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode vhead = new ListNode();
        vhead.next = root;
        ListNode tmp = vhead;
        while (index>0){
            if(tmp.next == null)
                return;
            tmp = tmp.next;
            index --;
        }
        if(tmp.next == null)
            return;
        tmp.next = tmp.next.next;
        root = vhead.next;
    }
}