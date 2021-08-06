import preDefine.TreeNode;

public class JZ26 {

    public static void main(String args[]){
        TreeNode a=new TreeNode(4);
        a.left = new TreeNode(8);
        a.right = new TreeNode(9);
        TreeNode b=new TreeNode(4);
        b.left = new TreeNode(8);
        b.right = new TreeNode(9);

        System.out.println();


    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            boolean b = isSubStructureSameRoot(A, B);
            if (b)
                return b;
        }
        return (isSubStructure(A.left, B) ||
                        isSubStructure(A.right, B));
    }

    public boolean isSubStructureSameRoot(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null || A.val!=B.val)
            return false;
        return isSubStructureSameRoot(A.left,B.left) && isSubStructureSameRoot(A.right,B.right);
    }
}

