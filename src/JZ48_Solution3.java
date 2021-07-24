import java.util.HashMap;
import java.util.HashSet;

public class JZ48_Solution3 {
    public static void main(String[] args){
        System.out.print(lengthOfLongestSubstring_withoutHashSet("abba"));
    }
    public static int lengthOfLongestSubstring(String s) { //88ms
        int ans = 0;
        int curMax = 0;
        HashSet<Character> set = new HashSet<>();
        for(int index = 0; index<s.length(); index++){
            if(!set.contains(s.charAt(index))){
                set.add(s.charAt(index));
                curMax ++;
            }else {
                set.clear();
                set.add(s.charAt(index));
                //找到l的位置
                int i = index -1;
                while (true){
                    set.add(s.charAt(i));
                    if(s.charAt(i) == s.charAt(index)){
                        break;
                    }
                    i --;
                }//更新
                curMax = index - i;
            }
            ans = Math.max(curMax,ans);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_chararray(String s) {
        char[] chars = s.toCharArray(); //49ms
        int ans = 0;
        int curMax = 0;
        HashSet<Character> set = new HashSet<>();
        for(int index = 0; index<s.length(); index++){
            if(!set.contains(chars[index])){
                set.add(chars[index]);
                curMax ++;
            }else {
                set.clear();
                set.add(chars[index]);
                //找到l的位置
                int i = index -1;
                while (true){
                    set.add(chars[i]);
                    if(chars[i] == chars[index]){
                        break;
                    }
                    i --;
                }//更新
                curMax = index - i;
            }
            ans = Math.max(curMax,ans);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_withoutHashSet(String s) {// 2ms
        char[] chars = s.toCharArray();
        int ans = 0;
        int curMax = 0;
        int[] Lastpos = new int[128];
        for (int i = 0; i<Lastpos.length;i++){
            Lastpos[i] = -1;
        }
        for(int index = 0; index<s.length(); index++){
            if(Lastpos[chars[index]] == -1){
                Lastpos[chars[index]] = index;
                curMax ++;
            }else {
                //!!!!!!这一步很重要，即要么是上一个的curMax加上新的数，即curMax+1
                // 要么是从新出现的字母到上一次该字母出现的距离
                //其实有一个preMax
                //应该是curMax = Math.min(index - Lastpos[chars[index]],preMax + 1)
                curMax = Math.min(index - Lastpos[chars[index]],curMax + 1);
                //即将进入下一个循环，preMax = curMax;
                //更新
                Lastpos[chars[index]] = index;

            }
            ans = Math.max(curMax,ans);
        }
        return ans;
    }

    public int lengthOfLongestSubstring_HashMap(String s) {//4ms
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

    public static int lengthOfLongestSubstring_(String s) { //2ms
        if(s.length()==0 || s==null )
            return 0;
        char str[] = s.toCharArray();
        int N = str.length;
        int[] last = new int [128];
        for (int i=0;i<last.length;i++){
            last[i] = -1;
        }
        last[str[0]] = 0;
        int Max = 1;
        int preMaxLen = 1;
        for (int i = 1; i < N;i++){
            preMaxLen = Math.min((i - last[str[i]]),preMaxLen+1);
            Max = Math.max(Max,preMaxLen);
            last[str[i]] = i;
        }
        return Max;
    }
}
