import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JZ38 {
    //回溯法 模板
    /*
    void backtracking(参数) { 参数一般很多
    if (终止条件) {
        存放结果;
        return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理节点;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果
    }
}
    * */

    public static void main(String[] args){
        permutation("aab");
    }

    public static String[] permutation(String s){
        int len = s.length();
        List<String> stringArrayList = new ArrayList<String>();
        boolean[] vis = new boolean[len];

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder perm = new StringBuilder();
        backtrack(chars,0,len,perm,stringArrayList,vis);
        String[] res = new String[stringArrayList.size()];
        for (int i = 0;i<stringArrayList.size();i++){
            res[i] = stringArrayList.get(i);
        }
        return res;
    }

    public static void backtrack(char[] chars, int index, int len, StringBuilder perm, List<String> rec, boolean[] vis){
        if(index == len){
            rec.add(perm.toString());
            return;
        }
        for(int i = 0; i < len;i++){
            if(vis[i] || i> 0 && chars[i-1] == chars[i] && vis[i-1] == false)
                continue;
            vis[i] = true;
            perm.append(chars[i]);
            backtrack(chars, index+1, len, perm, rec, vis);
            //***********最关键的回溯操作***********回溯：即发生在递归函数之后的操作**************
            perm.deleteCharAt(perm.length() - 1);
            vis[i] = false;
            //*********以上回溯完成，回溯即在下一层的递归操作完成后回溯到原本的状态*********
        }
    }
}
