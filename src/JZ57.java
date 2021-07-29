import java.util.HashMap;
import java.util.HashSet;

public class JZ57 {
    public int[] twoSum(int[] nums, int target) {
//        // 两数之和
//        HashSet<Integer> set= new HashSet<>();
//        for(int num : nums){
//            int div = target -num;
//            if(set.contains(div))
//                return new int[]{num, div};
//            else set.add(num);
//        }
//        return null;

        //排序的可以使用一头一尾双指针
        int p1 = 0, p2 = nums.length-1;
        while (p1 < p2){
            int sum = nums[p1] + nums[2];
            if(sum > target)
                p2--;
            else if(sum < target)
                p2 ++;
            else return new int[]{p1, p2};
        }
        return null;
    }

}
