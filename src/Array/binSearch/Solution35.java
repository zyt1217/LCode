package Array.binSearch;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (r+l)>>1;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid]){
                r = mid - 1;
                continue;
            }
            if(target > nums[mid]){
                l = mid + 1;
                continue;
            }
        }
        return target > nums[mid]? mid + 1: mid;
    }
}
