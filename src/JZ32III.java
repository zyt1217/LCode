import preDefine.TreeNode;

import java.util.*;

public class JZ32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            List<Integer> levelans= new LinkedList<>();
            Queue<TreeNode> levelque = new LinkedList<>();

            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                levelans.add(temp.val);
                levelque.add(temp);
            }
            if((i & 1) == 0)
                Collections.reverse(levelans);
            ans.add(levelans);
            i++;
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
