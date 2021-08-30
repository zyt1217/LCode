package Recur;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    List<List<String>> ans;
    Deque<String> path;
    String cut;
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        ans = new ArrayList<>();
        path = new LinkedList<>();
        recur (0);
        return ans;
    }

    public void recur(int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            cut = s.substring(index, i + 1);
            if(!isSymmetricString(cut))
                continue;
            path.addLast(cut);
            recur(i + 1);
            path.removeLast();
        }

    }
    public boolean isSymmetricString(String string){
        if(string.length() == 0)
            return false;
        for(int i = 0; i < (string.length()>>1); i++){
            if(string.charAt(i) - string.charAt(string.length() - 1 - i) != 0){
                return false;
            }
        }
        return true;
    }
}
