package Hash.array;

import java.util.ArrayList;
import java.util.List;

public class Solution1002 {
    public static void main(String[] args){
        System.out.print(commonChars(new String[]{"cool","lock","cook"}));;
    }
    public static List<String> commonChars(String[] words) {
        int[] hash1 = new int[26];

        for (int i = 0; i < words[0].length(); i++){
            hash1[words[0].charAt(i)-'a'] ++;
        }
        for(int k = 1; k < words.length; k ++){
            int[] hash2 = new int[26];
            for(int j = 0; j < words[k].length(); j ++){
                hash2[words[k].charAt(j)-'a'] ++;
            }
            for (int i = 0; i < 26; i++){
                hash1[i] = Math.min(hash1[i], hash2[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i< 26; i++){
            for(int j = 0; j< hash1[i];j++){
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }
        return ans;
    }
}
