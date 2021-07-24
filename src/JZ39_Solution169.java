import java.util.HashMap;

public class JZ39_Solution169 {

    public static void main(String[] args){
        int[] a = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.print(majorityElementMVote(a));
    }
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else {
                int temp = map.get(i) + 1;
                if(temp>=len/2 + len%2)
                    return i;
                map.put(i , temp);
            }
        }

        int ans = 0;
        for(int num: map.keySet()){
            if(map.get(num)>=len/2 + len%2)
                ans = num;
        }
        return ans;
    }

    // 摩尔投票法
    public static int majorityElementMVote(int[] nums){
        int len = nums.length;
        int index = 0;
        int vote = 1;
        int choice = nums[0];

        for (index = 1;index<len;index++){
            if(vote == 0)
                choice = nums[index];
            if(nums[index] != choice)
                vote --;
            else vote ++;
        }
        return choice;
    }

}
