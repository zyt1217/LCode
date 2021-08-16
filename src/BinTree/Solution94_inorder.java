package BinTree;

import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution94_inorder {
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
        //记忆：中序遍历不忘“左链入栈”
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while(root != null || !stk.isEmpty() ){
            if(root != null){// 一旦弹出一个节点，继续做“左链入栈”操作
                stk.push(root);
                root = root.left;//左
            }else {
                root = stk.pop();
                list.add(root.val);//中
                root = root.right;//右 右侧迭代 右边的左链再入栈
            }
        }
        return list;
    }
}
