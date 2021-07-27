public class JZ55I_Solution104 {

    public int maxDepth1(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null && root.right==null)
            return maxDepth1(root.left)+1;
        if(root.right!=null && root.left==null)
            return maxDepth1(root.right)+1;
        if(root.right == null)
            return 1;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right))+1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
