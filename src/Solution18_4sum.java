import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18_4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length<4)
            return ans;
        Arrays.sort(nums);
        for(int p1 = 0; p1 < nums.length - 3; p1 ++){
            if(p1 > 0 && nums[p1] == nums[p1-1])
                continue;
            for (int p2 = p1 +1; p2 < nums.length - 2; p2 ++){
                if(p2 > p1 +1 && nums[p2] == nums[p2-1])
                    continue;
                int left = p2 +1;
                int right = nums.length-1;
                while (left < right){
                    if(nums[p1] + nums[p2] + nums[left] + nums[right] == target){
                        ans.add(new ArrayList<>(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left<right && nums[left] == nums[left -1])
                            left++;
                        while (left<right && nums[right] == nums[right + 1])
                            right--;
                    }else if(nums[p1] + nums[p2] + nums[left] + nums[right] > target){
                        right--;
                    }else left++;
                }
            }
        }
        return ans;
    }
}
