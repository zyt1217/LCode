import java.util.HashMap;

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null )
            return 0;
        char str[] = s.toCharArray();
        int N = str.length;
        int[] last = new int [128];
        for (int i=0;i<128;i++){
            last[i] = -1;
        }
        last[str[0]] = 0;
        int Max = 1;
        int preMaxLen = 1;
        for (int i = 1; i < N;i++){
            preMaxLen = Math.min((i - last[str[i]]),preMaxLen+1);
            Max = Math.max(Max,preMaxLen);
            last[str[i]] = i;
        }
        return Max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int l=0;
        int r=0;
        int ans = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r!=chars.length){
            if(map.containsKey(chars[r])){
                l = Math.max(map.get(chars[r]) +1,l);
                map.replace(chars[r],r);
            }else map.put(chars[r],r);
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }

}

