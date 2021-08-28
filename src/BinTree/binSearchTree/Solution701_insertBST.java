package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution701_insertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return dfs(root,val);
    }

    public TreeNode dfs(TreeNode root, int val){
        if(root == null)
            return new TreeNode(val);
        if(root.val < val)
            root.right = dfs(root.right,val);
        if(root.val > val)
            root.left = dfs(root.left,val);
        return root;
    }

    public TreeNode insertIntoBST_iterator(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode cur = root;
        TreeNode pre = root;
        while (cur != null){
            pre = cur;
            if(cur.val > val)
                cur = cur.left;
            else if(cur.val < val)
                cur = cur.right;

        }
        if(pre.val > val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);
        return root;
    }
}
