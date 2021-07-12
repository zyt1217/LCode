public class JZ21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int i = 0,j = 0;
        for(int num: nums){
            if((num & 1) == 0){
                ans[len-1-j] = num;
                j++;
            }else {
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
}
