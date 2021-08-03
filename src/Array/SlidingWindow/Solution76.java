package Array.SlidingWindow;

public class Solution76 {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC","ABC");
    }
    public static String minWindow(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int tlen = tchar.length;
        int[] map = new int[128];
        String ans = "";
        for(char ch : tchar)
            map[ch] --;
        int left = 0, right = 0;
        int count = 0;
        while(right < schar.length){
            map[schar[right]] ++;
            if(map[schar[right]] <= 0)
                count ++;
            while(count == tlen && map[schar[left]] > 0){
                map[schar[left]] --;
                left ++;
            }
            if(count == tlen)
                if(ans.equals("") || ans.length() > right - left + 1)
                    ans = s.substring(left,right+1);
            right++;
        }
        return ans;

    }
}
