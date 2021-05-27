public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n;i++){
            if(nums[i]<=0){
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i<n;i++){
            if(Math.abs(nums[i])<=n){
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        for(int i = 0; i< n;i++){
            if(nums[i]>0)
                return i+1;
        }
        return n+1;
    }
}
