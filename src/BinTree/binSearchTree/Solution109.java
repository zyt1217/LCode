package BinTree.binSearchTree;

import preDefine.ListNode;
import preDefine.TreeNode;

public class Solution109 {
    ListNode pointer;
    public TreeNode sortedListToBST(ListNode head) {
        this.pointer = head;
        int len = 0;
        ListNode tmp = head;
        while (tmp!=null){
            tmp = tmp.next;
            len ++;
        }
        return buildBST_inorder(0,len - 1);

    }
    //链表顺序是中序遍历顺序，所以从中序遍历中构建出树，而每次赋值的顺序即是链表遍历顺序。
    public TreeNode buildBST_inorder(int left, int right){
        if(left > right)
            return null;
        int mid = (right + left) >> 1;
        TreeNode root = new TreeNode();
        root.left = buildBST_inorder(left, mid - 1);
        root.val = pointer.val;
        pointer = pointer.next;
        root.right = buildBST_inorder(mid + 1, right);
        return root;
    }
}
