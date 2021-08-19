package BinTree;

import preDefine.TreeNode;

public class JZ27_Solution226_mirror {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;      //中
        mirrorTree(root.right); //左
        mirrorTree(root.left);  //右
        return root;
    }
}
