package BinTree.buildTree;

import preDefine.TreeNode;

public class Solution654 {

    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0,nums.length);
    }
    public TreeNode dfs(int left, int right){//左闭右开
        if(right - left < 1)
            return null;
        if(right - left == 1)
            return new TreeNode(nums[left]);
        int max = Integer.MIN_VALUE;
        int maxIndex = nums[left];
        for (int i = left; i < right; i++){
            if(nums[i] >= max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(left, maxIndex);
        root.right = dfs(maxIndex + 1, right);
        return root;
    }
}
