package Recur.stringCut;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    List<String> ans;
    StringBuilder path;
    String s;
    int minLen;
    int timeOfMinLen;
    String cut;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        int len = s.length();
        ans = new ArrayList<>();
        path = new StringBuilder();
        if(len < 4 || len > 12)
            return ans;
        else if(len <= 10){
            minLen = 1;
            timeOfMinLen = 4 - ((len - 4 + 1)>>1);
        }
        else if(len == 11){
            minLen = 2;
            timeOfMinLen = 1;
        }
        else if(len == 12){
            minLen = 3;
            timeOfMinLen = 4;
        }
        recur(0,1, timeOfMinLen);
        return ans;

    }

    public void recur(int index, int part ,int leftTimeOfMinLen){
        if(part == 5){
            ans.add(new String(path.substring(1)));
            return;
        }

        for(int i = index + minLen - 1;i < s.length() && i < index + 3 ; i++){
            if(leftTimeOfMinLen == 0 && i+1 - index == minLen || part == 4 && i + 1 < s.length())
                continue;

            cut = s.substring(index,i+1);
            if(i+1 - index > 1 && s.charAt(index) - '0' ==0 || Integer.parseInt(cut) - 255 > 0)
                return;

            path.append('.').append(new String(cut));
            recur(i+1, part+1, i+1 -index == minLen?leftTimeOfMinLen - 1:leftTimeOfMinLen);
            path.delete(path.length() - 1 - (i+1 - index),path.length());
        }
    }
}

