package BinTree.binSearchTree;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution501 {
    private static TreeNode pre;
    private static int max = 1;
    private static int sum = 1;
    private static List<Integer> ans;

    public static int[] findMode(TreeNode root) {
        ans  = new LinkedList<>();
        ans.add(root.val);
        dfs(root);
        int[] res = new int[ans.size()];
        for(int i = 0; i< res.length; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static void dfs(TreeNode root){
        if(root == null)
            return;

        dfs(root.left);
        if(pre == null){
            pre = root;
        }else {
            if(root.val == pre.val)
                sum ++;
            else {
                pre = root;
                sum = 1;
            }
            if(sum > max){
                ans.clear();
                ans.add(root.val);
                max = sum;
            }
            if(sum == max){
                if(ans.get(ans.size()-1) != root.val)
                    ans.add(root.val);
            }
        }
        dfs(root.right);
    }
}

