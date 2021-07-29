import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JZ57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 0, limit = (target-1)>>1;
        for(int i = 1; i <= limit; i++){
            int a = 1, b = 1;
            long c =  (long)- Math.pow(i,2) + i - 2L *target;
            long delta = 1 - 4*a*c;
            if(delta < 0)
                continue;
            int delta_sqrt = (int) Math.sqrt(delta);
            if((long)delta_sqrt*delta_sqrt == delta && ((delta_sqrt - 1) & 1) == 0){
                int root = (-1+ delta_sqrt) >> 1;
                if(i < root){
                    int[] res = new int[root - i + 1];
                    for (int k = i; k <= root; k++)
                        res[k-i] = k;
                    list.add(res);
                }
            }
//            for(int j = i;;j++){
//                sum += j;edfg7u,timvy68tgv,fjmuy678
//                if(sum > target){
//                    sum = 0;
//                    break;
//                }else if(sum == target){
//                    int[] res = new int[j-i+1];
//                    for(int k = i; k<=j;k++)
//                        res[k-i] = k;
//                    list.add(res);
//                    sum = 0;
//                    break;
//                }
//            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public int[][] findContinuousSequence1(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }


}
