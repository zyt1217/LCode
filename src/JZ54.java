import java.util.ArrayList;
class t{
    public static void main(String[] args){
        JZ54 j = new JZ54();
        TreeNode root = new TreeNode();
//        root.right = new TreeNode(4);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
        System.out.print(j.kthLargest_0726(root, 1));
    }

}

public class JZ54 {

    public ArrayList<Integer> mid = new ArrayList<>();
    public int index = 1;
    public int ans;


    int k;
    public int kthLargest_0726(TreeNode root, int k) {
        if(root == null)
            return ans;
        kthLargest_0726(root.right, k);
        if(index == k)
            ans = root.val;
        index ++;
        kthLargest_0726(root.left, k);

        return ans;
    }

    public int kthLargest(TreeNode root, int k) {
        if(k == 0)
            return root.val;
        if(root == null)
            return 0;
        kthLargest(root.right,k);
        if(index == k) {
            ans = root.val;
            index++;
            return ans;
        }
        if(index > k){
            return ans;
        }
        index++;
        kthLargest(root.left,k);
        return ans;
    }

    public void DFSmid(TreeNode root){
        if(root == null)
            return;
        DFSmid(root.left);
        mid.add(root.val);
        DFSmid(root.right);
    }

    public int DFSmidBigEnd(TreeNode root, int k){
        if(k == 0)
            return root.val;
        if(root == null)
            return 0;
        DFSmidBigEnd(root.right,k);
        if(index == k) {
            ans = root.val;
            return ans;
        }
        index++;
        DFSmidBigEnd(root.left,k);
        return ans;
    }
}
