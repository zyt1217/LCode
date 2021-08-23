package BinTree.buildtree;

import preDefine.TreeNode;

import java.util.Arrays;

public class Solution106{

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int index = 0;
        for (;index < inorder.length; index ++){
            if(inorder[index] == root.val)
                break;
        }
        int leftlen = index;
        int rightlen = inorder.length - index - 1;

        int[] leftinorder = new int[leftlen];
        int[] rightinorder = new int[rightlen];
        int[] leftpostorder = new int[leftlen];
        int[] rightpostorder = new int[rightlen];

        System.arraycopy(inorder,0,leftinorder,0,leftlen);
        System.arraycopy(inorder, leftlen + 1, rightinorder,0,rightlen);
        System.arraycopy(postorder,0,leftpostorder,0,leftlen);
        System.arraycopy(postorder,leftlen,rightpostorder,0,rightlen);
        root.left = buildTree(leftinorder,leftpostorder);
        root.right = buildTree(rightinorder,rightpostorder);
//        root.left = buildTree(Arrays.copyOfRange(inorder,0,leftlen), Arrays.copyOfRange(postorder,0,leftlen));
//        root.right = buildTree(Arrays.copyOfRange(inorder,leftlen + 1,inorder.length),Arrays.copyOfRange(postorder,leftlen,inorder.length - 1))
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return dfs(inorder,0,inorder.length,
                postorder,0,postorder.length);
    }

    public TreeNode dfs(int[] inorder, int inLeft, int inRight, // [left, right)是前开后闭
                        int[] postorder, int postLeft, int postRight){
        if(inRight - inLeft < 1)
            return null;
        if(inRight - inLeft == 1)
            return new TreeNode(inorder[inLeft]);
        TreeNode root = new TreeNode();
        root.val = postorder[postRight - 1];
        int rootindex = 0;
        for(;rootindex < inRight;rootindex ++){
            if(inorder[rootindex] == root.val)
                break;
        }
        root.left = dfs(inorder, inLeft, rootindex,
                        postorder, postLeft, postLeft + (rootindex - inLeft));
        root.right= dfs(inorder,rootindex + 1, inRight,
                        postorder,postLeft + (rootindex - inLeft),postRight - 1);
        return root;

    }
}
