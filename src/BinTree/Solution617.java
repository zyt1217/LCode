package BinTree;

import preDefine.TreeNode;

public class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }


    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        TreeNode root = new TreeNode();
        if(root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }
        if(root1 == null){
            root.val = root2.val;
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        }

        if(root2 == null) {
            root.val = root1.val;
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right,null);
        }
        return root;

//        TreeNode left1 = root1==null?null:root1.left;
//        TreeNode left2 = root2==null?null:root2.left;
//        TreeNode right1 = root1==null?null:root1.right;
//        TreeNode right2 = root2==null?null:root2.right;
//        int leftval = root1==null?0:root1.val;
//        int rightval = root2==null?0:root2.val;
//        root.val = leftval + rightval;
//        root.left = mergeTrees(left1, left2);
//        root.right = mergeTrees(right1,right2);
//        return root;
    }
}
