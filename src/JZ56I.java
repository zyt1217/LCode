import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JZ56I {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        int div = 1;
        while ((div & xor) == 0)
            div = div << 1;
        int a = 0, b = 0;
        for (int num : nums){
            if((num & div) == 0){
                b ^= num;
            }else a ^= num;
        }
        return new int[]{a,b};


    }
}
