package Array.deleteElement_doublePoint;

public class Solution283 {
    //移动0
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] == 0){
                fast ++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        while (slow < nums.length){
            nums[slow] = 0;
            slow ++;
        }
    }
}
