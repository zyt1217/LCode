import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class meituan3 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[][] m = new int[len][len];
        for(int i=0; i < len;i++ ){
            scan.nextLine();
            for(int j =0 ;j<len;j++){
                m[i][j] = scan.nextInt();
            }
        }
        solution s = new solution();
        s.string = new StringBuilder();
        s.set = new HashSet<>();
        s.recur(0,s.string,len, m);
        System.out.println(s.set.size());


    }

}
class solution{
    StringBuilder string;
    HashSet<String> set;
    public void recur(int index, StringBuilder string, int len,int[][] m){
        if(string.length() == 5 || string.charAt(0) == string.charAt(4)){
            int minindex = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 4; i++){
                if(Integer.parseInt(String.valueOf(string.charAt(i))) < min) {
                    min = Integer.parseInt(String.valueOf(string.charAt(i)));
                    minindex = i;
                }
            }
            string = new StringBuilder(string.substring(minindex, string.length()) + string.substring(0, minindex));
            set.add(String.valueOf(string));
        }
        for(int i = 0; i < len; i++){
            if(m[index][i] == 0)
                recur(index +1 ,string,len,m);
            else {
                string.append(i);
                recur(index +1 ,string,len,m);
                string.deleteCharAt(string.length()-1);
            }
        }
    }
}
