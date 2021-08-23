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
}
