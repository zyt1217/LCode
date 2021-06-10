import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[][] num = {{'a','b','c'},
                        {'d','e','f'},
                        {'g','h','i'},
                        {'j','k','l'},
                        {'m','n','o'},
                        {'p','q','r','s'},
                        {'t','u','v'},
                        {'w','x','y','z'}};
        char[] digit = digits.toCharArray();
        for(char c: digit){
             c - '2' + 2
        }
    }
}
