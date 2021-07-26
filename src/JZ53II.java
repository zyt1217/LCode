public class JZ53II {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length-1;
        if(l == r)
            return nums[0] == 0? 1:0;
        while(l<r){
            if(r == l + 1)
                break;
            if((l + r)/2 == nums[(l+r)/2])
                l = (l+r)/2;
            else r = (l + r)/2;
        }
        if(nums[l] + 2 == nums[r])
            return nums[l]+1;
        else return nums[r]== r?nums[r] + 1:nums[l] - 1;
    }
}
