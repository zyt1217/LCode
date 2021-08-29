package BinTree.binSearchTree;

import preDefine.TreeNode;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        dfs(root,nums,0,nums.length - 1);
        return root;
    }

    public TreeNode dfs(TreeNode root, int[] nums, int l, int r){
        if(r < l)
            return null;
        int mid = (r+l)>>1;
        root.val = nums[mid];
        root.left = dfs(new TreeNode(), nums, l, mid - 1);
        root.right = dfs(new TreeNode(), nums, mid + 1, r);
        return root;
    }





}
