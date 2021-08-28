package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        TreeNode pre = root;
        TreeNode cur = root;
        while (cur != null && cur.val != key){
            pre = cur;
            if(cur.val < key)
                cur = cur.right;
            else if(cur.val > key)
                cur = cur.left;
        }
        if (cur != null) {
            if(pre.val < key){
                pre.right = deleteBSThead(cur);
            }else if(pre.val > key){
                pre.left = deleteBSThead(cur);
            }
            if(pre.val == key)
                return deleteBSThead(root);
        }
        return root;
    }

    public TreeNode deleteBSThead(TreeNode root){
        if(root.left ==null && root.right ==null)
            return null;
        TreeNode tmp = root.left;
        if(tmp == null)
            return root.right;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        tmp.right = root.right;
        return root.left;
    }
}