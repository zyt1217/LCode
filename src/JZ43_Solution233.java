public class JZ43_Solution233 {
    public static void main(String[] args){
        System.out.print(countDigitOne(1));
    }
    public static int countDigitOne(int n) {
        int res = 0;
        int high,cur,low;
        for(int i = 0;Math.pow(10,i) <= n; i++){
            low = n%(int)Math.pow(10,i);
            cur = (int)(n/Math.pow(10,i))%10;
            high = n/(int)Math.pow(10,i+1);
            if(cur == 0)
                res += high*(int)Math.pow(10,i);
            else if(cur == 1)
                res += high*(int)Math.pow(10,i) + low + 1;
            else
                res += (high + 1)*(int)Math.pow(10,i);
        }
        return res;
    }
}
