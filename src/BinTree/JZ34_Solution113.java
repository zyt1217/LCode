package BinTree;

import preDefine.Tree;
import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JZ34_Solution113 {
    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,targetSum,path);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> path){
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null)
            if(targetSum - root.val == 0){
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
        dfs(root.left, targetSum - root.val, path);
        dfs(root.right, targetSum - root.val, path);
        path.remove(path.size()-1);
    }
}
