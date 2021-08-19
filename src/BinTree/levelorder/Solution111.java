package BinTree.levelorder;

import preDefine.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null)
            left = minDepth(root.left);
        if(root.right != null)
            right = minDepth(root.right);
        return 1 + Math.min(left,right);
    }

    //迭代法 更快
    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i< size; i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null)
                    queue.offer(tmp.right);
                if(tmp.left == null && tmp.right == null)
                    return ans;
            }
            ans ++;
        }
        return ans;
    }
}
