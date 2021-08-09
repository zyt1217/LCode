package Array.doublePoint;

public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int p1 = 0, p2 = nums.length-1;
        int[] res = new int[nums.length];
        for(int k = nums.length - 1; k>=0;k--){
            if(Math.abs(nums[p1]) < Math.abs(nums[p2])){
                res[k] = nums[p2] * nums[p2];
                p2 --;
            }else {
                res[k] = nums[p1] * nums[p1];
                p1 ++;
            }
        }
        return res;
    }
}
