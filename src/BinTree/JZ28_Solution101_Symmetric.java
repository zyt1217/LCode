package BinTree;

import preDefine.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JZ28_Solution101_Symmetric {
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
        System.out.println(isSymmetric(a));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return  is2Symmetric(root.left,root.right);
    }
    public static boolean is2Symmetric(TreeNode left, TreeNode right){
        if(left ==null && right==null)
            return true;
        if(!(left!=null && right!=null))
            return false;
        return left.val == right.val && is2Symmetric(left.left,right.right) && is2Symmetric(left.right,right.left);
    }

    public static boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left == null && right == null)
                continue;
            if(!(left!=null && right!=null) || left.val != right.val)
                return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
