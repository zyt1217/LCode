package Recur.subSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    List<List<Integer>> ans;
    LinkedList<Integer> path;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        path = new LinkedList<>();
        recur(0);
        return ans;
    }

    public void recur(int index){
        if(path.size() != 0){
            ans.add(new ArrayList<>(path));
            if(path.size() == nums.length)
                return;
        }
        for(int i = index; i < nums.length ;i++){
            path.offer(nums[i]);
            recur(i + 1);
            path.pollLast();
        }
    }
}
