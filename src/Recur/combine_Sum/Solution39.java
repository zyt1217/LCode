package Recur.combine_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    List<List<Integer>> ans;
    List<Integer> path;
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        path = new ArrayList<>();
        recur(0, 0);
        return ans;
    }
    public void recur(int index, int sum){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(sum > target)
            return;
        for(int i = index; i < candidates.length ;i++){
            path.add(candidates[i]);
            sum += candidates[i];
            recur(i, sum);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
