import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args){
        //Scanner scan = new Scanner(System.in);
        int n = 992;
        if(n <= 2) {
            System.out.println(2 * n);
            return;
        }
        if(n == 3){
            System.out.println(6);
            return;
        }
        int ans = 6;
        for(int i = 1; i <= n-3; i++){
            ans = 2*ans - 2*i;
            ans = ans %998244353;
        }
        ans = ans;
        System.out.print(ans);
    }
}
