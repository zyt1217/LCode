package BinTree;

import preDefine.TreeNode;

public class JZ27_Solution226 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.right);
        mirrorTree(root.left);
        return root;
    }
}
