public class JZ44_Solution400 {
    public static void main(String[] args){
        System.out.print(findNthDigit(18));
    }
    public static int findNthDigit(int n) {
        if(n <=9 )
            return n;
        int i = 1;
        int og = n;
        for(;9*Math.pow(10,i-1)*i<og;i++){
            n -= (int)9*Math.pow(10,i-1)*i;
        }
        int pos = n%i;
        int num = (n+1)/i;
        for(int j = i - 1;j>0;j--){
            num += 9*(int)Math.pow(10,j-1);
        }
        if(pos != 0){
            return (num/(int)Math.pow(10,i-pos))%10;
        }else return num%10;
    }
}
