import java.util.Locale;

public class JZ58I_Solution151 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i]).append(" "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }
    public  String reverseWords1(String s){
        s = s.trim();
        if(s.length() == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        int p2 = s.length()-1;
        int p1 = s.length()-1;
        while (p1 >0){
            if(s.charAt(p1) != ' ' && s.charAt(p2) != ' '){
                p1--;
            }
            if(s.charAt(p1) == ' ' && s.charAt(p2) != ' '){
                res.append(s.substring(p1+1, p2+1)).append(' ');
                p1 --;
                p2 = p1;
            }
            if(s.charAt(p1) == ' ' && s.charAt(p2) == ' '){
                p1 --;
                p2 --;
            }
        }
        return res.append(s.substring(0,p2+1)).toString().trim();
    }
}
