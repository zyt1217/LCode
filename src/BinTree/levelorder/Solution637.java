package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            double levelsum = 0.0;
            int count = 0;
            Queue<TreeNode> levelque = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode tmp = queue.poll();
                count ++;
                levelsum += tmp.val;
                levelque.offer(tmp);
            }
            ans.add((double) levelsum/count);
            while (!levelque.isEmpty()){
                TreeNode temp = levelque.poll();
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return ans;
    }

}
