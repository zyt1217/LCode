package Greedy;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, ans = 0;
        while (i < g.length && j < s.length){
            if(s[j] < g[i]){
                j++;
            }else {
                i++;
                j++;
                ans++;
            }
        }
        return ans;
    }
}
