public class JZ56II {
    public static void  main(String[] args){
        int[] nums = new int[]{86,38,67,65,61,72,42,1,17,88,65,72,64,54,22,45,92,1,38,17,3,68,34,64,29,27,6,22,54,56,34,61,38,92,48,82,73,62,86,27,11,6,22,98,86,37,15,61,88,29,73,15,62,1,6,67,11,72,16,87,67,62,42,16,45,98,7,27,87,37,16,56,88,64,15,68,42,98,29,82,65,82,54,7,17,68,92,45,37,87,56,11,48,34,7,48,73};
        System.out.print(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
//        int[] bits = new int[31];
//        //记录用于异或的1，2，2^2, ... 2^30 表示2^i
//        int bit = 1;
//        for(int i = 0; i<31; i ++){
//            bits[i] = bit;
//            bit = bit << 1;
//        }
        int[] ans = new int[31];
        for(int i = 0; i < 31; i++){
            for(int num : nums){
                ans[i] += ((num & (1 << i)) >> i) % 3;
                ans[i] %= 3;
            }
        }
        int res = 0;
        for(int i = 0; i< 31; i++){
            if(ans[i] == 1)
                res += (1 << i);
        }
        return res;
    }
}
