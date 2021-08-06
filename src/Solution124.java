import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;


public class Solution124 {

    public static int InitSums(TreeNode root, ArrayList<Integer> sums) {
        if(root == null)
            return 0;
        int leftSum = InitSums(root.left,sums);
        int rightSum = InitSums(root.right,sums);
        int tmp = Math.max(leftSum + root.val,rightSum + root.val);
        int LinkRootSum = Math.max(tmp, root.val);
        sums.add(Math.max(LinkRootSum,leftSum + rightSum +root.val));
        return LinkRootSum;
    }
    public static int maxPathSum(TreeNode root){
        ArrayList<Integer> sums = new ArrayList<>();
        InitSums(root,sums);
        sums.sort(Comparator.reverseOrder());
        return sums.get(0);
    }
}
