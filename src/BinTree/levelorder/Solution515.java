package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelmax = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                levelmax = Math.max(levelmax,tmp.val);
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }
            ans.add(levelmax);
        }
        return ans;
    }
}
