
class node{
    int index;
    int data;
    node left;
    node right;
}
public class Solution338 {

    public static void main(String args[]){
        Solution338 s = new Solution338();
        int [] ans = s.countBits(8);
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public int[] countBits3(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i = 1; i <= num; i++)
        {
            if((i&1)== 1)
            {
                result[i] = result[i-1] + 1;
            }
            else
            {
                result[i] = result[i/2];
            }
        }
        return result;
    }



    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num == 0)
            return ans;
        node root =new node();
        createTree(root,1,ans,1);
        ans[0] = 0;
        return ans;
    }


    public void createTree(node node, int i, int[] ans,int data){
        if(i>ans.length-1)
            return;
        node node1 = new node();
        node1.data = data;
        ans[i] = node1.data;
        node1.index = i;
        createTree(node1.left,2*i,ans,node1.data);
        createTree(node1.right,2*i+1,ans,node1.data+1);
    }


    public int[] countBits1(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        if(num == 0)
            return ans;
        ans[1] = 1;
        if (num ==1)
            return ans;
        int knum;
        for(int i = 2; i<=num;i = 2*i){
            knum = i;
            for(int j = i;j<2*i;j++){
                if(j-i<=knum/2){
                    ans[j] = ans[j-(knum/2)];
                }else {
                    ans[j] = ans[j-(knum/2)]+1;
                }
                if (j == num)
                    return ans;
            }
        }
        return ans;
    }
}

