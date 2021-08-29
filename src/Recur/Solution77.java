package Recur;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> ans;
    public List<Integer> list;
    public int k;
    public int n;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        ans = new ArrayList<>();
        list = new ArrayList<>();
        recur(1);
        return ans;
    }
    public void recur(int num){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = num; i <= n - (k - list.size()) + 1; i++){
            list.add(i);
            recur(i + 1);
            list.remove(list.size() - 1);
        }
    }
}
