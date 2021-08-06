package Hash.array;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int[] hash = new int[128];
        for(char sch:schar){
            hash[sch] --;
        }
        for(char tch:tchar){
            hash[tch] ++;
        }
        for (int i = 0; i< 128; i++){
            if(hash[i] != 0)
                return false;
        }
        return true;
    }
}
