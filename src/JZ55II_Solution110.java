public class JZ55II_Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public boolean isBalanced_cut(TreeNode root) {
        return recur(root) != -1;
    }

    public int recur(TreeNode root){
        if(root == null)
            return 0;
        int left = recur(root.left);
        if(left == -1)
            return -1;
        int right = recur(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left-right) > 1? -1:Math.max(left,right)+1;
    }
}
