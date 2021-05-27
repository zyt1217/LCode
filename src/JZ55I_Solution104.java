import java.util.LinkedList;
import java.util.Queue;

public class JZ55I_Solution104 {

    int i = 0;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null && root.right==null)
            return maxDepth(root.left)+1;
        if(root.right!=null && root.left==null)
            return maxDepth(root.right)+1;
        if(root.right==null && root.left==null)
            return 1;
        if(root.right!=null && root.left!=null)
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        return 0;
    }
}
