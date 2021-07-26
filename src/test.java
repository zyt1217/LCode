import java.util.*;

public class test {

    private static String s = "abba";
    public static void main(String[] arg){
//        test t = new test();
//        int a = t.lengthOfLongestSubstring(s);
//        System.out.println(t.lengthOfLongestSubstring(s));
//        System.out.println(brackets(""));

//        Random rand = new Random(104567);
//        double x = 0.4;
//        for(int i = 0;i<10;i++){
//            double a =35.80  -x+2*x*(0.01*rand.nextInt(100));
//            System.out.println(a);
//        }
        String s = "1234567";
        System.out.print(s.substring(7,8));

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

}
