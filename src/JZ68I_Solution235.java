import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JZ68I_Solution235 {
    static HashSet<TreeNode> pset = new HashSet<>();
    static HashSet<TreeNode> qset = new HashSet<>();

    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        lowestCommonAncestor(root,root.left,root.right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //迭代
        if(p.val>q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root!=null){
            if(root.val>q.val)
                root = root.left;
            else if(root.val<p.val)// 此处的左或者右应该是平行关系， 一次循环只能做一次
                root = root.right;
            else break;
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
        //递归
        if(p.val>q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return dfs(root,p,q);
    }
    public static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.val<p.val)
            return dfs(root.right, p, q);
        if(root.val>q.val)
            return dfs(root.left,p,q);
        return root;
    }



    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        allAncestor_p(root,p);
        allAncestor_q(root,q);
        int i = 0;
        List<TreeNode> list = new ArrayList<>();
        for(TreeNode t : qset){
            if((t.val <= Math.max(p.val,q.val)) && (t.val >= Math.min(p.val,q.val))) {
                list.add(t);
            }
        }
        if(list.size() == 1)
            return list.get(0);
        else return (p.left == q || p.right == q) ? p: q;
    }

    public static boolean allAncestor_p(TreeNode root, TreeNode target){
        if(root == target){
            pset.add(root);
            return true;
        }else if(root == null)
            return false;
        boolean x = allAncestor_p(root.right, target) || allAncestor_p(root.left, target);
        if(x) {
            pset.add(root);
            return true;
        }else
            return false;
    }

    public static boolean allAncestor_q(TreeNode root, TreeNode target){
        if(root == target){
            if (pset.contains(root)){
                qset.add(root);
            }
            return true;
        }else if(root == null)
            return false;
        boolean x = allAncestor_q(root.right, target) || allAncestor_q(root.left, target);
        if(x) {
            if (pset.contains(root)){
                qset.add(root);
            }
            return true;
        }else
            return false;
    }
}
