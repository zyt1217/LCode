package Recur;

import sun.awt.image.ImageWatched;

import java.util.*;

public class Solution17 {
    public static void main(String args[]){
        letterCombinations2("23");
    }

    public List<String> letterCombinations(String digits) {//13ms
        List<String> ans = new ArrayList<>();
        StringBuilder d = new StringBuilder(digits);
        char[][] num = {{'a','b','c'},
                        {'d','e','f'},
                        {'g','h','i'},
                        {'j','k','l'},
                        {'m','n','o'},
                        {'p','q','r','s'},
                        {'t','u','v'},
                        {'w','x','y','z'}};
        while (d.length()<4)
            d.append('0');
        if(d.charAt(0)!='0'){
            for(int i = 0; i<num[d.charAt(0)-'2'].length;i++){
                if(d.charAt(1)!='0'){
                    for(int j = 0; j<num[d.charAt(1)-'2'].length;j++){
                        if(d.charAt(2)!='0'){
                            for(int k = 0; k<num[d.charAt(2)-'2'].length;k++){
                                if(d.charAt(3)!='0')
                                    for(int l = 0; l<num[d.charAt(3)-'2'].length;l++)
                                        ans.add(""+num[d.charAt(0)-'2'][i]+
                                                num[d.charAt(1)-'2'][j]+
                                                num[d.charAt(2)-'2'][k]+
                                                num[d.charAt(3)-'2'][l]);
                                else ans.add(""+num[d.charAt(0)-'2'][i]+num[d.charAt(1)-'2'][j]+num[d.charAt(2)-'2'][k]);
                            }
                        }
                        else ans.add(""+num[d.charAt(0)-'2'][i]+num[d.charAt(1)-'2'][j]);
                    }
                }
                else ans.add(""+num[d.charAt(0)-'2'][i]);
            }
        }
        return ans;
    }

    public static List<String> letterCombinations2(String digits) {// 10ms
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

    public static List<String> letterCombinations1(String digits) {//0ms
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

    public static void backtrack(String digits,List<String> ans, StringBuilder combination, char[][] num,int index){
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
