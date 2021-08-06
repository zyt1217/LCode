import preDefine.TreeNode;

public class JZ07_Solution105 {

    public static void main(String[] args){
        int [] preorder = new int[]{3,9,20,15,7};
        int [] inorder  = new int[]{9,3,15,20,7};
        buildTree(preorder,inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[0];
        int i = 0;
        int l = inorder.length;
        for(;i<l;i++){
            if(inorder[i] == root.val)
                break;
        }

        int[] inorderL = new int[i];
        int[] inorderR = new int[l-i-1];
        int[] preorderL = new int[i];
        int[] preorderR = new int[l-i-1];

        System.arraycopy(inorder,0,inorderL,0,i);
        System.arraycopy(inorder,i+1,inorderR,0,l-i-1);
        System.arraycopy(preorder,1,preorderL,0,i);
        System.arraycopy(preorder,1+i,preorderR,0,l-i-1);

//        root.left = new preDefine.TreeNode();
//        root.right = new preDefine.TreeNode();

        root.left = buildTree(preorderL,inorderL);
        root.right = buildTree(preorderR,inorderR);
        return root;


    }


}
