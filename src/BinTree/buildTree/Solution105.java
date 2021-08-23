package BinTree.buildTree;

import preDefine.TreeNode;

public class Solution105 {

    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0,preorder.length,
                0,inorder.length);
    }

    public TreeNode dfs(int preLeft, int preRight,//前开后闭区间
                    int inLeft, int inRight){
        if(inRight - inLeft < 1)
            return null;
        if(inRight -inLeft == 1)
            return new TreeNode(inorder[inLeft]);
        TreeNode root = new TreeNode();
        root.val = preorder[preLeft];
        int rootIndex = 0;
        for (; rootIndex < inRight; rootIndex++){
            if(inorder[rootIndex] == root.val)
                break;
        }
        root.left = dfs(preLeft + 1, preLeft + 1 + (rootIndex - inLeft),
                        inLeft, rootIndex);
        root.right= dfs(preLeft + 1 + (rootIndex - inLeft), preRight,
                        rootIndex + 1, inRight);
        return root;
    }

}
