package BinTree.levelorder;

public class Solution117 {
    //O(1)空间
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node leftmost = root;
        while(leftmost != null){
            //先去找下一层的leftmost，之后给它定一个虚拟头节点
            Node tmp = leftmost;
            while (tmp != null && tmp.left == null && tmp.right ==null){
                tmp = tmp.next;
            }
            if(tmp == null)
                break;
            Node vhead = new Node();
            Node link = vhead;
            if(tmp.left != null)
                vhead.next = tmp.left;
            else vhead.next = tmp.right;
            while (tmp != null){
                //是一个节点的子节点之间的操作
                //link是这一层tmp之前最右一个节点
                if(tmp.left != null) {
                    link.next = tmp.left;
                    link = link.next;
                }
                if(tmp.right != null){
                    link.next = tmp.right;
                    link = link.next;
                }
                tmp = tmp.next;
            }
            leftmost = vhead.next;
        }
        return root;
    }
    public Node connect1(Node root) {
        if(root == null)
            return null;
        Node leftmost = root;
        while(leftmost != null){
            //先去找下一层的leftmost，之后给它定一个虚拟头节点
            Node tmp = leftmost;
            Node vhead = new Node();
            Node link = vhead;
            while (tmp != null){
                //是一个节点的子节点之间的操作
                //link是这一层tmp之前最右一个节点
                if(tmp.left != null) {
                    link.next = tmp.left;
                    link = link.next;
                }
                if(tmp.right != null){
                    link.next = tmp.right;
                    link = link.next;
                }
                tmp = tmp.next;
            }
            leftmost = vhead.next;
        }
        return root;
    }
}
