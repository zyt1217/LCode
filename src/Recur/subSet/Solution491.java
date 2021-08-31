package Recur.subSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution491 {
    List<List<Integer>> ans;
    LinkedList<Integer> path;
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        path = new LinkedList<>();
        recur(0);
        return ans;
    }

    public void recur(int index){
        if(path.size() > nums.length)
            return;
        if(path.size() >= 2)
            ans.add(new ArrayList<>(path));

        int used[] = new int[201]; //在每一层使用一个哈希表来记录nums[i]有无被使用过
        for(int i = index; i < nums.length ;i++){
            if(!path.isEmpty() && nums[i] < path.peekLast() || used[nums[i] + 100] == 1)
                continue;
            used[nums[i] + 100] = 1;
            path.offer(nums[i]);
            recur(i + 1);
            path.pollLast();
        }
    }
}
