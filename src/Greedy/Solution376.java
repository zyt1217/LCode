package Greedy;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1;
        int last = nums[0];
        if(nums.length == 1)
            return nums.length;
        int i = 0;
        boolean flag = false;
        for(; i< nums.length; i++){
            if(nums[i] != nums[0]){
                flag = nums[i] - nums[0] >0;
                break;
            }
        }
        if(i == nums.length)
            return ans;

        last = nums[i];
        for(; i < nums.length; i++){
            if(flag){
                if(nums[i] >= last){
                    last = nums[i];
                }else {
                    last = nums[i];
                    flag = false;
                    ans ++;
                }
            }else {
                if(nums[i] <= last){
                    last = nums[i];
                }else {
                    last = nums[i];
                    flag = true;
                    ans ++;
                }
            }
        }
        return ans+1;
    }

    public int wiggleMaxLength1(int[] nums) {
        int preDiff = 0, curDiff = 0;
        int ans = 1;
        for (int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i-1];
            if(preDiff <= 0 && curDiff >0 || preDiff >=0 && curDiff < 0){
                ans++;
                preDiff = curDiff;//放在里面可以避免prediff出现等于0的情况，每次更新时候必定curdiff是反向的
                //避免了[1,1,2,2,3,3,4]这种情况的错误
            }
        }
        return ans;
    }
}
