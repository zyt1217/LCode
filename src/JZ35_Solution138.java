import java.util.HashMap;

public class JZ35_Solution138 {
    public Node copyRandomList_hashmap(Node head) {
        if(head == null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null){
            Node tmp = new Node(curr.val);
            map.put(curr,tmp);
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public Node copyRandomList_doubleNode(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;
        while (cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            //如果在是cur.random是null的话，cur.next.random也应该为null，而本身其也是没有定义的，所以不做任何操作。
            cur = cur.next.next;
        }

        //拆分
        cur = head.next;
        Node og = head, res = head.next;
        while (cur.next != null){
            og.next = og.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            og = og.next;
        }
        og.next = null;
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
