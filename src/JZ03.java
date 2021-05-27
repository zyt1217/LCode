public class JZ03 {
    public int findRepeatNumber(int[] nums) {
        boolean[] once = new boolean[nums.length];
        for(int i = 0; i<nums.length;i++){
            if(once[nums[i]])
                return nums[i];
            once[nums[i]] = true;
        }
        return 0;
    }
}
