package Array.deleteElement;

public class Solution27 {
    //双指针法
    public int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if(nums[fast] == val)
                fast ++;
            else {
                nums[slow] = nums[fast];
                slow ++;
                fast ++;
            }
        }
        return slow;
    }
}
