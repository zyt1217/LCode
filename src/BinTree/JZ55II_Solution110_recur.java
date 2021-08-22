package BinTree;

import preDefine.TreeNode;

public class JZ55II_Solution110_recur {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced_cut(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root){
        if(root == null)
            return 0;
        int left = recur(root.left);
        if(left == -1)
            return -1;
        int right = recur(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left-right) > 1? -1:Math.max(left,right)+1;
    }

    public boolean isBalanced_recur(TreeNode root) {
        return depth_recur(root) != -1;
    }
    //回溯法 返回高度，并且可以得到是否平衡，平衡则返回高度，不平衡则使用-1标记
    public int depth_recur(TreeNode root){
        if(root == null)
            return 0;
        int left = depth_recur(root.left);
        if(left == -1)
            return -1;
        int right = depth_recur(root.right);
        if(right == -1 || Math.abs(left - right) > 1)
            return  -1;
        else return Math.max(left,right) + 1;
    }
}
