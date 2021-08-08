package Hash.map;

import java.util.HashMap;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //总结，看到形如：A+B....+N=0的式子，要转换为(A+...T)=-((T+1)...+N)再计算，
        // 这个T的分割点一般是一半，特殊情况下需要自行判断。定T是解题的关键。
        HashMap<Integer, Integer> sum_time = new HashMap<>();
        for(int a : nums1){
            for (int b : nums2){
                if(sum_time.containsKey(a+b)){
                    sum_time.put(a+b, sum_time.get(a+b) + 1);
                }else sum_time.put(a+b, 1);
            }
        }
        int ans = 0;
        for(int c : nums3){
            for(int d : nums4){
                if(sum_time.containsKey(-c-d)){
                    ans += sum_time.get(-c-d);
                }
            }
        }
        return ans;
    }

}
