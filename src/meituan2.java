import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        scan.nextLine();
        String s = scan.next();
        //System.out.print(s);
        int p1 = 0, p2 = len-1;
        int ans = 0;
        int index = 0;
        for(int i = 0; i< len; i++){
            if(s.charAt(i) == 'c'){
                ans+= i -index;
                index ++;
            }

        }

//        while (p1 < p2){
//            while (s.charAt(p1) == 'c')
//                p1 ++;
//            while (s.charAt(p2) == 'a')
//                p2 --;
//            ans += p2-p1;
//            p1 ++;
//            p2 --;
//        }
        System.out.print(ans);
    }
}
