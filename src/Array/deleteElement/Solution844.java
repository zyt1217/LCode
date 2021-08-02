package Array.deleteElement;

import java.util.Arrays;

public class Solution844 {
    public static void main(String[] args){
        backspaceCompare("a#c","b");
    }
    public static boolean backspaceCompare(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int slow = 0, fast = 0;
        while (fast < s.length()){
            if(schar[fast] == '#'){
                fast ++;
                slow --;
            }
            else {
                if(slow < 0)
                    slow = 0;
                schar[slow] = schar[fast];
                fast ++;
                slow ++;
            }
        }
        if (slow < 0) slow = 0;
        //char数组转换回来用String.valueOf
        s = String.valueOf(schar).substring(0,slow);
        slow = 0;
        fast = 0;
        while (fast < t.length()){
            if(tchar[fast] == '#'){
                fast ++;
                slow --;
            }
            else {
                if(slow < 0)
                    slow = 0;
                tchar[slow] = tchar[fast];
                fast ++;
                slow ++;
            }
        }
        if (slow < 0) slow = 0;
        t = String.valueOf(tchar).substring(0,slow);

        return s.equals(t);
    }
}
