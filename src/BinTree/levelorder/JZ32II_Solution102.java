package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JZ32II_Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            ans.add(levelans);
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
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelans= new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                levelans.add(temp.val);
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
            }
            ans.add(levelans);
        }
        return ans;
    }
}
