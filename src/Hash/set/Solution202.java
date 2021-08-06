package Hash.set;

import java.util.HashSet;

public class Solution202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)){
            set.add(n);
            int newN = 0;
            while (n>0){
                newN += (n%10) * (n%10);
                n /= 10;
            }
            n = newN;
        }
        return set.contains(1);
    }
}
