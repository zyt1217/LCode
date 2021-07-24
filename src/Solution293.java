public class Solution293 {
    //移动0
    public void moveZeroes(int[] nums) {
        int firstZero = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0 && firstZero < 0) {
                firstZero = i;
                continue;
            }
            if(nums[i] != 0 && firstZero >=0) {
                nums[firstZero] = nums[i];
                nums[i] = 0;
                firstZero++;
            }
        }
    }
}
