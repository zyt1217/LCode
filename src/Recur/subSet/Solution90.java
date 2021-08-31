package Recur.subSet;

import java.util.*;

public class Solution90 {
    List<List<Integer>> ans;
    LinkedList<Integer> path;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        ans = new ArrayList<>();
        path = new LinkedList<>();
        recur(0);
        return ans;
    }

    public void recur(int index){
        ans.add(new ArrayList<>(path));
        if(path.size() >= nums.length)
            return;
        for(int i = index; i < nums.length ;i++){
            if(i > index && nums[i]==nums[i-1])
                continue;
            path.offer(nums[i]);
            recur(i + 1);
            path.pollLast();
        }
    }
}

