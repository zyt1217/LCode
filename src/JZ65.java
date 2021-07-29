public class JZ65 {
    public static void main(String[] args){
        System.out.print(add(111,899));
    }
    public static int add(int a, int b) {
        //^可以表示两数之和，进位的地方使用 & 来找
        return (a ^ b) + ((a & b) << 1);
    }
}
