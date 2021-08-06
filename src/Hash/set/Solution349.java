package Hash.set;

import java.util.HashSet;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num))
                set2.add(num);
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for(int num:set2){
            res[i] = num;
            i++;
        }
        return res;
    }
}
