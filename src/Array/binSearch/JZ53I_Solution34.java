package Array.binSearch;

import java.util.Arrays;

public class JZ53I_Solution34 {
    public static void main(String[] args){
        search(new int[]{5,7,7,8,8,10}, 8);
    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0 || target > nums[nums.length-1] || target < nums[0])
            return 0;
        int index = binSearch(nums, 0, nums.length-1, target);
        if(index == -1)
            return 0;
        int i = index, j = index;
        while (i>=0 && nums[i] == nums[index])
            i--;
        while (j<nums.length && nums[j] == nums[index])
            j++;
        return j-i-1;
    }
    public static int binSearch(int[] nums, int l, int r, int target){
        if(l > r)
            return -1;
        int mid = nums[(l + r)>>1];
        if(target == mid)
            return (l + r)>>1;
        else if(target > mid){
            return binSearch(nums, (l + r)/2+1, r, target);
        }else {
            return binSearch(nums, l, (l + r)/2-1, target);
        }
    }
}
