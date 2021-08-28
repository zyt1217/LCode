package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        if(root.val > val)
            return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }

    public TreeNode searchBST_iterator(TreeNode root, int val) {
        while (root != null){
            if(root.val > val)
                root = root.left;
            else if(root.val < val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
