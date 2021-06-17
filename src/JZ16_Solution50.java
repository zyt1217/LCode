public class JZ16_Solution50 {
    public double myPow(double x, int n) {
        long m = n;
        if(m<0){
            m = -m;
            x = 1/x;
        }
        double ans = 1;
        while(m!=0){
            long b = m & 1;
            if(b != 0)
                ans = ans*x;
            if(x ==0)
                return 0;
            x = x*x;
            m = m >> 1;
        }
        return ans;
    }
}
