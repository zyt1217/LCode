package Recur.combine_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    public List<List<Integer>> ans;
    public List<Integer> path;
    public int[] candidates;
    public int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        Arrays.sort(candidates);
        this.target = target;
        ans = new ArrayList<>();
        path = new ArrayList<>();
        recur(0,0);
        return ans;
    }

    public void recur(int index, int sum){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < candidates.length && candidates[i] <= target - sum; i++){
            if(i>index && candidates[i] == candidates[i-1])
                continue;
            sum += candidates[i];
            path.add(candidates[i]);
            recur(i + 1, sum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
