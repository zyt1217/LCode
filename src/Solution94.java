import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        LDR(list,root);
        return list;
    }

    public void LDR(List<Integer> list, TreeNode root){
        if(root == null)
            return;
        LDR(list, root.left);
        list.add(root.val);
        LDR(list, root.right);
    }

    public List<Integer> inorderTraversalwithIteration(TreeNode root){
        //迭代方法
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty() ){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
