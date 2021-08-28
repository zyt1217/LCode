import java.util.*;

public class test {


    String s = "123 456 7";
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if(in.hasNext()){
            System.out.println(in.nextLine());
            in.nextLine();
            String a = in.nextLine();
            System.out.println(a);
        }

        in.close();
    }




    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int l=0;
        int r=0;
        int ans = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r!=chars.length){
            if(map.containsKey(chars[r])){
                l = Math.max(map.get(chars[r]) +1,l);
                map.replace(chars[r],r);
            }else map.put(chars[r],r);
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }

    public static int brackets(String s) {
        int n = s.length();
        int ans = 0;

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '(' || ch == '[' || ch == ']' || ch == '{' || ch == '}') {
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return -1;
                    }
                    stack.pop();
                    ans ++;
                } else {
                    stack.push(ch);
                }
            }
        }
        if(stack.isEmpty())
            return ans;
        else return -1;
    }
    
    public static int[] func(int num, String ... strings){
        int[] ans = new int[num];
        if(strings.length!=num)
            return null;
        for(int i = 0;i<num;i++){
            ans[i] = brackets(strings[i]);
        }
        return ans;
    }



    public int del_space(String buf) {
        int ans = 0;
        for (int i = 0; i < buf.length(); i++) {
            if (buf.charAt(i) == ' ') {
                ans++;
                buf = buf.substring(0, i) + buf.substring(i + 1);
            }
            //System.out.println(buf);
        }
        return ans;
    }
//        String[] strings = buf.split(" ");
//        StringBuilder tmp = new StringBuilder();
//        for (String s : strings){
//            tmp.append(s);
//        }
//        buf = String.valueOf(tmp);
//        return strings.length -1;
//    }

}

class a{
    public static void main(String[] args){
        test t = new test();
        t.del_space(t.s);
        System.out.print(t.s);
    }

}
