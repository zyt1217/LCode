package BinTree.levelorder;


import preDefine.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i< size; i++){
                Node tmp = queue.poll();
                level.add(tmp.val);
                queue.addAll(tmp.children);
            }
            ans.add(level);
        }
        return ans;
    }

}
