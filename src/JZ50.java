public class JZ50 {
    public char firstUniqChar(String s) {
        int[] chars = new int[128];
        for(int i = 0; i<s.length(); i++){
            chars[s.charAt(i)] ++;
        }
        int i = 0;
        for (; i<s.length(); i++){
            if(chars[s.charAt(i)] == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
