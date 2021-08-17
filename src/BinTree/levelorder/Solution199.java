package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int count = 1;
            Queue<TreeNode> level = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode tmp = queue.poll();
                if(count == 1) {
                    count--;
                    ans.add(tmp.val);
                }
                level.offer(tmp);
            }
            while (!level.isEmpty()){
                TreeNode temp = level.poll();
                if(temp.right!= null)
                    queue.offer(temp.right);
                if(temp.left != null)
                    queue.offer(temp.left);
            }
        }
        return ans;
    }

}
