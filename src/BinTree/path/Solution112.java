package BinTree.path;

import preDefine.TreeNode;

import java.awt.*;

public class Solution112 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(11);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root,1));

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return targetSum - root.val == 0;
        return (hasPathSum(root.left, targetSum - root.val))
                || (hasPathSum(root.right, targetSum - root.val));
    }
}
