import java.util.HashSet;

public class JZ61 {
    public boolean isStraight(int[] nums) {
        //输入类型是int[] JQK是11 12 13 A是1
        //顺子有且只有5张牌，0可以代替任何牌
        //由于有0的存在，在max与min之间只要差距在3以内，都可以有剩余的0来填补，多余的0也无所谓
        int max = 1, min = 13;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(set.contains(nums[i]))
                    return false;
                else {
                    set.add(nums[i]);
                    max = Math.max(max, nums[i]);
                    min = Math.min(min, nums[i]);
                }
            }
        }
        return max-min<5;
    }
}
