public class JZ58II {

    public static void main(String[] args){
        String s = reverseLeftWords("abcdefg",2);
        System.out.println(s);

    }
    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] newchars = new char[len];
        for(int i = 0;i<len;i++){
            if(i<len-n){
                newchars[i] = chars[i+n];
            }else
            newchars[i] = chars[i+n-len];
        }
        return new String(newchars);
    }
}
