package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelans= new LinkedList<>();
            Queue<TreeNode> levelque = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                levelans.add(temp.val);
                levelque.add(temp);
            }
            ans.add(0, levelans);
            while (!levelque.isEmpty()){
                if(levelque.peek().left != null){
                    queue.offer(levelque.peek().left);
                }
                if(levelque.peek().right != null){
                    queue.offer(levelque.peek().right);
                }
                levelque.poll();
            }
        }
        return ans;
    }
}
