package Strings;

public class Solution28_KMP {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int[] next = new int[needle.length()];
        getNext(next,needle);
        //初始化，i指向文本起始位置，j为-1，与next数组存储相同，访问使用j+1
        int j = -1;
        for(int i = 0;i<haystack.length();i++){
            //遇到不匹配的字符，则寻找前一个字符的匹配的位置，
            //前一个字符匹配的位置即next记录该字符前缀的末位位置
            while (j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            //匹配上了，则ij都后移
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length() - 1){//上面的j已经加过 即为上一个if中的j+1
                //返回位置，i往前减去匹配串长度
                return (i - needle.length() +1);
            }
        }
        //未找到，返回-1
        return -1;
    }
    public void getNext(int[] next, String s){
        //初始化 j -1 (j+1)是前缀末位位置，从前缀起始位置开始，
        // i 1 是后缀末位位置，从后缀起始位置1开始，同时i用来遍历
        int j = -1;
        next[0] = j;
        for(int i = 1; i<s.length(); i++){
            //到j i 结尾前后缀不匹配时候，使用前一个匹配上的j，退回直到与i匹配
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)){
                j = next[j];
            }
            //j i结尾前后缀匹配上，各后移
            if(s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            //next[i]记录前缀末尾位置
            next[i] = j;
        }
    }
}
