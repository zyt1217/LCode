import javax.print.DocFlavor;
import java.util.Arrays;

public class JZ19_Solution10 {
    public static void main(String[] args){
        boolean a = isMatch("abbabaaaaaaacaa",
                            "a*.*b.a.*c*b*a*c*");
        System.out.print(String.valueOf(a));
    }

    public boolean isMatch_stdSolution(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];//很巧妙，状态算上00，则可以从1开始列举，1就代表s的第一个字符
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {//当遇到匹配a*或.*时候，f[i][j] = f[i-1][j](逐个匹配) 或者 f[i][j] = f[i][j-2]()
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1))
                        f[i][j] = f[i][j] || f[i - 1][j];
                } else
                    if (matches(s, p, i, j))
                        f[i][j] = f[i - 1][j - 1];
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0)//对应的这里要看是否有会越界因为是比较i-1和j-1，而j不可能是0，所以i=0时候总是输出false
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static boolean isMatch(String s, String p) {
        int s1 = 0,p1 = 0,p2 = 1;

        if(s.length() == 0)
            if(p.length() == 0)
                return true;
            else if(p.length()>=2 && p.charAt(p2)=='*')
                return isMatch(s.substring(s1),p.substring(2));
            else
                return false;
        if(p.length() == 0)
            return false;

        boolean p2isX = p2 < p.length() && p.charAt(p2) == '*';//当p2存在且为*
        if(s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.'){//字母与字母匹配，字母与.匹配

            if(p2<p.length() && p.charAt(p2) != '*')//p2不是*的情况
                return isMatch(s.substring(s1+1),p.substring(p1+1));

            else if(p2isX){//当p2是*，则要考虑a*中0个a的情况，从s串的s1开始的之后的任意串都可能是*之后的串匹配；
                if(p2+1<p.length()){//当*不是最后一个 如abccccd和abc*cd 这个时候c可以和c*中的c匹配也可以跳过c*和d前面的匹配，而这都是未知的，用两情况的||运算
                    String np = p.substring(p2+1);
                    boolean b = false;//当s1是p1或p1是.(大前提),对于每一个c满足匹配，要么跳过c*，要么跳过自己。
                    for(;s1<s.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.' );s1++)//跳过自己，之后满足条件的下一个c来跳过c*
                        b = b || isMatch(s.substring(s1),np);//跳过c*
                    if(s1<s.length() && (s.charAt(s1) == p.charAt(p2+1) || p.charAt(p2+1) == '.'))//c（*）匹配完之后的紧接的一个
                        b = b || isMatch(s.substring(s1),np);
                    if(s1 == s.length())
                        b = b || isMatch(s.substring(s1),np);
                    return b;//可以直接return b????
                }else //当*是最后一个时候 考虑a*和.*
                    for(;s1<s.length();s1++)
                        if(p.charAt(p1) != s.charAt(s1) && p.charAt(p1) !='.')
                            return false;
                    return
                            true;

            }else//以上结束了p2存在的情况，当p2不存在时，p1即最后一个，此时大前提s1=p1,但是可能还有s2;
                return s1 == s.length() - 1;

        }else //当字母与字母不匹配也没有.的时候，还是两个情况：p2是否存在
            if(p2isX)
                return isMatch(s.substring(s1),p.substring(p1+2));//有*时候，则跳过这个值，继续算p2+1开始和s1+1的匹配
            else
                return false;//无*时，无法匹配
    }
}