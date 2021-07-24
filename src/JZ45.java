public class JZ45 {
    //自定义排序，x+y>y+x,说明x>y
    public String minNumber(int[] nums) {
        String[] numstr = new String[nums.length];
        for(int i = 0; i < numstr.length; i++){
            numstr[i] = String.valueOf(nums[i]);
        }
        quickSort(numstr,0,numstr.length-1);
        StringBuilder ans = new StringBuilder();
        for (String s:numstr){
            ans.append(s);
        }
        return ans.toString();
    }

    public void quickSort(String[] str, int l, int r){
        //递归终止条件
        if(l>=r)
            return;
        //哨兵比较
        int i = l,j=r;
        while (i<j){
            while (i<j && (str[l] + str[j]).compareTo(str[j] + str[l])<=0)
                j--;
            while (i<j && (str[i] + str[l]).compareTo(str[l] + str[i])<=0)
                i++;
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
        String tmp = str[i];
        str[i] = str[l];
        str[l] = tmp;
        quickSort(str, l, i-1);
        quickSort(str, i+1, r);
    }
}


