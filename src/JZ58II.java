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

    public static String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public String reversLeftWords2(String s, int n){
        char[] schar = s.toCharArray();
        int p1 = 0, p2 = n-1;
        while (p1 < p2){
            char tmp = schar[p1];
            schar[p1] = schar[p2];
            schar[p2] = tmp;
            p1 ++;
            p2 --;
        }
        p1 = n; p2 = schar.length -1;
        while (p1 < p2){
            char tmp = schar[p1];
            schar[p1] = schar[p2];
            schar[p2] = tmp;
            p1 ++;
            p2 --;
        }

        p1 = 0; p2 = schar.length-1;
        while (p1 < p2){
            char tmp = schar[p1];
            schar[p1] = schar[p2];
            schar[p2] = tmp;
            p1 ++;
            p2 --;
        }

        return String.valueOf(schar);
    }
}
