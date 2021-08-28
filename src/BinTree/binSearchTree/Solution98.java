package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean dfs(TreeNode root, Long max, Long min){
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return dfs(root.left, (long) root.val, min) && dfs(root.right, max, (long) root.val);
    }
}
