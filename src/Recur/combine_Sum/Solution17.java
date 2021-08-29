package Recur.combine_Sum;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Solution17 {

    public List<String> letterCombinations2(String digits) {// 10ms
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0)
            return ans;
        StringBuilder d = new StringBuilder(digits);
        int first = d.charAt(0) - '2';
        int len = digits.length();
        char[][] num = {{'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};
        for(char i: num[first])
            ans.add(String.valueOf(i));

        String temp = null;
        temp = ans.get(0);
        for(;temp.length()<len;){
            ans.remove(0);
            for(char i: num[d.charAt(temp.length())-'2'])
                ans.add(temp+i);
            temp = ans.get(0);
        }
        return ans;
    }

    public List<String> letterCombinations1(String digits) {//0ms
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        char[][] num = {{'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};
        backtrack(digits,ans,new StringBuilder(),num,0);
        return ans;
    }

    public void backtrack(String digits,List<String> ans, StringBuilder combination, char[][] num,int index){
        if(index==digits.length())
            ans.add(combination.toString());
        else {
            char digit = digits.charAt(index);
            int d = digit - '2';
            for(int i = 0;i<num[d].length;i++){
                combination.append(num[d][i]);
                backtrack(digits,ans,combination,num,index+1);
                combination.deleteCharAt(index);
            }
        }
    }

}
