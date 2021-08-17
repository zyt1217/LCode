package BinTree;

import preDefine.TreeNode;

import java.util.*;

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

    public List<Integer> inorderTraversal_uni(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }

}
