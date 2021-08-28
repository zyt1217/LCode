package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution530 {

    public int getMinimumDifference(TreeNode root) {
        return (int)dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public long dfs(TreeNode root, long min, long max){
        if(root == null)
            return Math.abs(max - min);
        long rootmin = Math.min(Math.abs(max - root.val), Math.abs(root.val - min));
        long leftmin = dfs(root.left, min, root.val);
        long rightmin = dfs(root.right, root.val, max);
        return Math.min(rootmin, Math.min(leftmin, rightmin));
    }


    public int min = Integer.MAX_VALUE;
    public TreeNode pre = null;
    public int getMinimumDifference_inorder(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        if(pre != null){
            int tmp = Math.abs(pre.val - root.val);
            min = Math.min(min, tmp);
        }
        pre = root;
        inorder(root.right);
    }
}

