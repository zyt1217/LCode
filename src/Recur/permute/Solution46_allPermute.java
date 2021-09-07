package Recur.permute;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution46_allPermute {

    List<List<Integer>> ans;
    Deque<Integer> path;
    int[] nums;
    int[] used;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        this.nums = nums;
        used = new int[nums.length];
        recur();
        return ans;
    }

    public void recur(){
        if(path.size() == nums.length){
            ans.add(new LinkedList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1)
                continue;
            used[i] = 1;
            path.add(nums[i]);
            recur();
            used[i] = 0;
            path.pollLast();
        }
    }

}
