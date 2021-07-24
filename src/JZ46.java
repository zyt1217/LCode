public class JZ46 {
    public static void main(String[] args){
        System.out.print(translateNum1(506));
    }
    public static int translateNum(int num) {
        String numstr = String.valueOf(num);
        int[] dp = new int[numstr.length()];
        dp[0] = 1;
        if(num<10)
            return 1;
        if(Integer.parseInt(numstr.substring(0,2)) <= 25)
            dp[1] = 2;
            else dp[1] = 1;
        for(int i = 2; i < dp.length;i++){
            if(Integer.parseInt(numstr.substring(i-1,i+1)) <= 25 && numstr.charAt(i-1) != '0')
                dp[i] = dp[i-2] + dp[i-1];
            else dp[i] = dp[i-1];
        }
        return dp[dp.length-1];
    }

    public static int translateNum1(int num) {
        String numstr = String.valueOf(num);
        int a = 1;
        int b;
        if(num<10)
            return 1;
        if(Integer.parseInt(numstr.substring(0,2)) <= 25)
            b = 2;
        else b = 1;
        for(int i = 2; i < numstr.length();i++){
            int tmp = b;
            if(Integer.parseInt(numstr.substring(i-1,i+1)) <= 25 && numstr.charAt(i-1) != '0')
                b = a + b;
            a = tmp;
        }
        return b;
    }
}

