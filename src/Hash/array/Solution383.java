package Hash.array;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(char c : magazine.toCharArray()){
            map[c - 'a'] ++;
        }
        for(char c : ransomNote.toCharArray()){
            if(map[c - 'a'] > 0)
                map[c - 'a'] --;
            else return false;
        }
        return true;
    }
}
