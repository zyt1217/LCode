package BinTree.levelorder;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution116 {
    public Node connect_queue(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i <size -1 ;i++){
                Node tmp = queue.poll();
                tmp.next = queue.peek();
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }
            Node tmp = queue.poll();
            tmp.next = null;
            if(tmp.left != null)
                queue.offer(tmp.left);
            if(tmp.right != null)
                queue.offer(tmp.right);
        }
        return root;
    }

    //O(1)空间
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node leftmost = root;
        while (leftmost.left != null){
            Node tmp = leftmost;
            while (tmp != null){
                tmp.left.next = tmp.right;
                if(tmp.next != null){
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    public Node connect_recur(Node root){
        if(root == null)
            return null;
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root.left == null)
            return;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        dfs(root.left);
        dfs(root.right);
    }

}
