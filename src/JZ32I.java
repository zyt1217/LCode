import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ32I {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            list.add(queue.peek().val);
            if(queue.peek().left != null){
                queue.offer(queue.peek().left);
            }
            if(queue.peek().right != null){
                queue.offer(queue.peek().right);
            }
            queue.poll();
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
