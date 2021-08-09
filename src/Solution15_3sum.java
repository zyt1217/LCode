import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution15_3sum {
    public static void main(String[] args){
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
            return new LinkedList<>();

        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        for(int p1 = 0; p1< nums.length-2; p1 ++){
            int p2 = p1 + 1, p3 = nums.length-1;
            if(nums[p1] > 0)
                break;
            if(p1 > 0 && nums[p1] == nums[p1-1])
                continue;
            while (p2 < p3){
                if(nums[p1] + nums[p2] + nums[p3] < 0){
                    p2 ++;
                }else if(nums[p1] + nums[p2] + nums[p3]>0){
                    p3 --;
                }else {
                    ans.add(new ArrayList<>(Arrays.asList(nums[p1] , nums[p2], nums[p3])));
                    p2 ++ ;
                    p3 -- ;
                    while (p2< p3 && nums[p2] == nums[p2 -1])
                        p2 ++;
                    while (p2< p3 && nums[p3] == nums[p3 + 1])
                        p3 --;
                }
            }
        }
        return ans;
    }

}
