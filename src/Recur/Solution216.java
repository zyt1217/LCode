package Recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution216 {

    public List<List<Integer>> ans;
    public List<Integer> path;
    public int k, n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(1,0);
        return ans;
    }

    public void dfs(int startNum, int sum){
        if(path.size() == k){
            if(sum == n)
                ans.add(new ArrayList<>(path));
            return;
        }

        int index = path.size() + 1; //本轮加入的是第index个数
        int remain = n - sum;//剩余需要相加的数
        int max = remain/(k - index + 1) - (k - index)/2; //本轮最大的数
        max = Math.min(max, 9);

        if(index == k){
            for(int i = max; i > path.get(path.size() - 1); i--){
                if(i + sum == n){
                    path.add(i);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    break;
                }
            }
            return;
        }



        for(int num = startNum; num <= max; num ++){
            path.add(num);
            sum += num;
            dfs(num + 1, sum);
            sum -=num;
            path.remove(path.size() - 1);
        }
    }

}

class test{
    public static void main(String[] args){
        Solution216 s = new Solution216();
        s.combinationSum3(3,9);
    }
}
