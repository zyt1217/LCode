import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class JZ68II_Solution236 {
    //在类中不要将变量初始化，否则提交会有问题
    //尽量不适用哈希set来输出，输出不保证有序，也不保证按照插入顺序
    static List<TreeNode> plist; //= new HashSet<>();
    static List<TreeNode> qlist; //= new HashSet<>();

    static TreeNode p;
    static TreeNode q;
    public static void main(String[] args){
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        System.out.print(lowestCommonAncestor(root,root.left.left.left,root.left).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        if(left == null && right != null)
            return right;
        if(left != null && right == null)
            return left;
        return null;
    }

    public static TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
//        p = this.p;
//        q = this.q;
        plist = new ArrayList<>();
        qlist = new ArrayList<>();
        allAncestor_p(root,p);
        allAncestor_q(root,q);
        return qlist.get(0);
    }

    public static TreeNode allAncestor_p(TreeNode root, TreeNode target){
        if(root == target){
            plist.add(root);
            return root;
        }else if(root == null)
            return null;
        //boolean x = allAncestor_p(root.right, target) || allAncestor_p(root.left, target);
        if(allAncestor_p(root.right, target) != null || allAncestor_p(root.left, target) != null) {
            plist.add(root);
            return root;
        }else
            return null;
    }

    public static TreeNode allAncestor_q(TreeNode root, TreeNode target){
        if(root == target){
            if (plist.contains(root)){
                qlist.add(root);
            }
            return root;
        }else if(root == null)
            return null;
        //boolean x = allAncestor_q(root.right, target) || allAncestor_q(root.left, target);
        if(allAncestor_q(root.right, target) != null || allAncestor_q(root.left, target)!= null) {
            if (plist.contains(root)){
                qlist.add(root);
            }
            return root;
        }else
            return null;
    }
}
