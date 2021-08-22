package BinTree;

import preDefine.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = queue.poll();
                if(i == 0)
                    ans = tmp.val;
                if(tmp.left != null) queue.offer(tmp.left);
                if(tmp.right != null) queue.offer(tmp.right);
            }
        }
        return ans;
    }
}
