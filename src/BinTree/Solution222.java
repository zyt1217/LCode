package BinTree;

import preDefine.TreeNode;

public class Solution222 {
    //完全二叉树节点个数
    //完全二叉树是由满二叉树组成的
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        countNodes(root);
    }
    public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int lefth = 0, righth = 0;
        TreeNode tmp = root;
        while (tmp != null){
            tmp = tmp.left;
            lefth ++;
        }
        tmp = root;
        while (tmp != null){
            tmp = tmp.right;
            righth ++;
        }
        if(lefth == righth)
            return (2 << lefth - 1) - 1;
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
