import preDefine.TreeNode;

public class JZ28_Solution101 {
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);
        System.out.println(isSymmetric(a));
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return  is2Symmetric(root.left,root.right);
    }
    public static boolean is2Symmetric(TreeNode a, TreeNode b){
        if(a ==null && b==null)
            return true;
        if(!(a!=null && b!=null))
            return false;
        return a.val == b.val && is2Symmetric(a.left,b.right) && is2Symmetric(a.right,b.left);
    }

}
