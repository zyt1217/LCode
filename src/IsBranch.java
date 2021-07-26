import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
public class IsBranch {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left =  new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        boolean ans = IsBranch(root,new int[]{1,3,6,7}, 4);
        System.out.println(ans);
    }
    public static boolean IsBranch(TreeNode root, int[] arr, int length){

        HashSet<Integer> arrayList = new HashSet<>();
        for(int i=0;i<length;i++)
            arrayList.add(arr[i]);
        int re = IsBranch1(root,arrayList,length);
        if(re==2)
            return true;
        return false;
    }


    public static int IsBranch1(TreeNode root, HashSet<Integer> arr, int length){
        HashSet<Integer> hashset = new HashSet<>();
//        for(int i=0;i<length;i++){
//            hashset.add(arr[i]);
//        }
        int tf = 0, l = 1, r = 1;

        if(arr.contains(root.val)){
            tf=1;
            arr.remove(root.val);
        }

        if(root.left != null)
            l = IsBranch1(root.left,arr,length);
        if(root.right != null)
            r= IsBranch1(root.right,arr,length);
        if(arr.contains(root.val)){
            tf=1;
            arr.remove(root.val);
        }
        if ((l==1 || r==1) && arr.isEmpty() || l==2 || r==2)
            return 2;

        if (tf==1 && (l==1||r==1)) return 1;

        return 0;
    }

}
