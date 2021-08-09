package Strings;

public class JZ05 {
    public static void main(String[] args){
        String s = "We are here";
        //replaceSpace(s);
        System.out.println(replaceSpace(s));
    }

    static String ans = "";
    public static String replaceSpace(String s) {
        if (s.equals("")){
            return ans;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i<s.length();i++){
            if(chars[i]!=' '){
                ans += chars[i];
            }else {
                ans += "%20";
            }
        }
        return ans;
    }
}
