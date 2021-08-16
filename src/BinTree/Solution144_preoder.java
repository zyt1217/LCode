package BinTree;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144_preoder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs_preorder(root,ans);
        return ans;
    }
    public void dfs_preorder(TreeNode root, List<Integer> ans){
        if(root == null)
            return;
        ans.add(root.val);
        dfs_preorder(root.left, ans);
        dfs_preorder(root.right,ans);
    }

    //迭代法前序遍历，使用栈
    public List<Integer> preorderTraversal_iterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            //这里判断null，即是递归中每次的判断
            if(pop.right != null)
                stack.push(pop.right);
            if(pop.left != null)
                stack.push(pop.left);
        }
        return ans;
    }
}
