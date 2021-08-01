package Array.binSearch;

public class Solution704 {
    public static void main(String[] args){
        search(new int[]{-1,0,3,5,9,12}, 9);
    }
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        int mid = 0;
        //这里l=r是有意义的
        while (l <= r){
            mid = (r+l) >> 1;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid]){
                r = mid-1;
                continue;
            }
            if(target > nums[mid]){
                l = mid +1;
                continue;
            }
        }
        return -1;
    }
}
