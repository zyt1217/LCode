import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution39 {
    public static void main(String[] arg){
        int []  candidates = new int[4];
        candidates[0] = 2;
        candidates[1] = 3;
        candidates[2] = 6;
        candidates[3] = 7;
        int target = 7;
        List<List<Integer>> x = combinationSum(candidates,target);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        System.out.print(ans);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;

    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        //在candidates当前idx位置，还需要组合出target，已经组合的数组为combine
        if (idx == candidates.length){
            return;
        }
        if(target <= 0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates,target,ans,combine,idx+1);
        if((target - candidates[idx])>=0){
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);

        }
    }

    public static int  MultiNum(int Num,int target){
        int x = 0;//乘数
        while (x*Num <= target){
            x++;
        }
        return x-1;
    }
    public static int listsum(List<Integer> list){
        int s = 0;
        for(int k = 0;k<list.size();k++){
            s = s+list.get(k);
        }
        return s;
    }

    public static boolean isExist(int[] arr,int value){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == value){
                return true;
            }
        }
        return false;
    }
    public static int[] delElement(int[] arr, int value){
        if(!isExist(arr,value)){
            return arr;
        }
        int[] res = new int[arr.length - 1];
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != value){
                res[index++] = arr[i];
            }
        }
        return res;
    }
    public static <T> List<T> deepCopy(List<T> src)  {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(byteOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(src);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(byteIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        @SuppressWarnings("unchecked")
        List<T> dest = null;
        try {
            dest = (List<T>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
