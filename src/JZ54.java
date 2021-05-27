import java.util.ArrayList;

public class JZ54 {

    public ArrayList<Integer> mid = new ArrayList<>();
    public int Index = 1;
    public int ans;

    public int kthLargest(TreeNode root, int k) {
        if(k == 0)
            return root.val;
        if(root == null)
            return 0;
        kthLargest(root.right,k);
        if(Index == k) {
            ans = root.val;
            Index++;
            return ans;
        }
        if(Index > k){
            return ans;
        }
        Index++;
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
        if(Index == k) {
            ans = root.val;
            return ans;
        }
        Index++;
        DFSmidBigEnd(root.left,k);
        return ans;
    }
}
