package BinTree.path;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        dfs(root, strings);
        return ans;

    }
    public void dfs(TreeNode root, List<String> strings){
        if(root == null)
            return;
        strings.add("->");
        strings.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            StringBuilder path = new StringBuilder();
            for (String s : strings){
                path.append(s);
            }
            ans.add(String.valueOf(path).substring(2));
            return;
        }
        if(root.left != null){
            dfs(root.left, strings);
            //recur...
            strings.remove(strings.size()-1);
            strings.remove(strings.size()-1);
        }
        if(root.right != null){
            dfs(root.right, strings);
            strings.remove(strings.size()-1);
            strings.remove(strings.size()-1);
        }
    }
}
