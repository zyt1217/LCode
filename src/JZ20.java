public class JZ20 {

    public static void main(String[] args){
        boolean a = isNumber("  26.  ");
        System.out.print(String.valueOf(a));
    }

    public static boolean isNumber(String s) {
        //空 整/小 （Ee 整） 空
        if(s.length() == 0)
            return false;
        int L =0;
        while(L<s.length()){
            if(s.charAt(L) != ' '){
                break;
            }
            L++;
        }
        int R = L;//整数和小数中不能有空格
        int M = L;
        boolean Eexist = false;
        while (R < s.length()){
            if((s.charAt(R) == 'E' || s.charAt(R) == 'e')) {
                Eexist = true;
                break;
            }
            else if(s.charAt(R) == ' ')
                break;
            else
                R++;
        }

        String baseNum = s.substring(L,R);

        if(Eexist){
            R++;
            M = R;
            if (R <s.length()) {
                while (R < s.length()) {
                    if (s.charAt(R) == ' ') {
                        break;
                    }
                    R++;
                }
            }else
                return false;
            String indexNum = s.substring(M,R);
            while (R < s.length()){
                if(s.charAt(R) != ' ')
                    return false;
                R ++;
            }
            return isInteger(indexNum) && (isInteger(baseNum) || isDecimal(baseNum));
        }else {
            while (R < s.length()){
                if(s.charAt(R) != ' ')
                    return false;
                R ++;
            }
            return isInteger(baseNum) || isDecimal(baseNum);
        }
    }

    //前后无空格了
    public static boolean isInteger(String s) {
        //s可能为空
        if(s.length() == 0)
            return false;
        if(s.length() == 1 && !isFigure(s.charAt(0)))
            return false;
        int index = 0;
        if(s.charAt(index) == '+' || s.charAt(index) == '-' || isFigure(s.charAt(0)))
            index ++;
        while (index<s.length()){
            if(!isFigure(s.charAt(index)))
                return false;
            index++;
        }
        return true;
    }

    public static boolean isDecimal(String s){
        if(s.length() == 0 ||s.length() == 1)
            return false;
        int index = 0;
        if(s.charAt(index) == '+' || s.charAt(index) == '-')
            index ++;
        if(index + 1 >= s.length())
            return false;
        if(s.charAt(index) == '.' && isFigure(s.charAt(index + 1))){
            index += 2;
            while (index < s.length()){
                if(!isFigure(s.charAt(index)))
                    return false;
                index++;
            }
            return true;
        }else {
            if(isFigure(s.charAt(index)))
                index++;
            else
                return false;
            int first = index - 1;
            while (index < s.length()){
               if(s.charAt(index) == '.'){
                   boolean L = true ,R =true;
                   for(int i = first;i < index;i++){
                       if(!isFigure(s.charAt(i))){
                           L = false;
                           break;
                       }
                   }
                   for(int i = index + 1; i<s.length();i++){
                       if(!isFigure(s.charAt(i))){
                           R = false;
                           break;
                       }
                   }
                   return L && R;
               }
               if(!isFigure(s.charAt(index)))
                   return false;
               index++;
            }
            return true;
        }
    }

    public static boolean isFigure(char c){
        return (c - '0' >= 0 && c - '9' <= 0);
    }

}
