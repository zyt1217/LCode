public class JZ67 {
    public static void main(String[] args){
        System.out.println(strToInt("  0000000000012345678"));
    }
    public static int strToInt(String str) {
        if(str.length() == 0)
            return 0;
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == ' ')
                continue;
            str = str.substring(i);
            if(str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) - '0' > 9 && str.charAt(0) - '0' < 0)
                return 0;
            break;
        }

        int flag = 1;
        int len = 0;
        int start = 0;
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }else if(str.charAt(0) == '-'){
            flag = -1;
            str = str.substring(1);
        }

        while (len < str.length() && str.charAt(len) - '0' <=9 && str.charAt(len) - '0' >= 0){
            len ++;
        }
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i) == '0')
                start++;
            else break;
        }
        str = str.substring(start,len);
        len = len - start;
        long temp = 0;
        if(len > 10){
            if(flag < 0)
                return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }else {
            for(int i = 0; i < str.length(); i++){
                temp += (str.charAt(i) - '0') *Math.pow(10,str.length()-i-1);
            }
            if(temp > Integer.MAX_VALUE){
                if(flag < 0)
                    return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }else return (int) temp * flag;
        }
    }
}
