package Strings;

public class Solution541II {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        for(int i = 0; i< res.length; i += 2*k ){
            int p1 = i;
            int p2 = Math.min(i+k-1, res.length-1);
            while (p1 < p2){
                char tmp = res[p1];
                res[p1] = res[p2];
                res[p2] = tmp;
                p1 ++;
                p2 --;
            }
        }
        return String.valueOf(res);
    }
}
