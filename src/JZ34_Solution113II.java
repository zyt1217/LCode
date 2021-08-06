import preDefine.Tree;
import preDefine.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JZ34_Solution113II {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> listAll = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        return path_Sum(root,target,listAll,list);
    }

    public static List<List<Integer>> path_Sum(TreeNode root, int sum, List<List<Integer>> listAll, List<Integer> list){//所有路径，不包含null节点的
        if(root == null)
            return listAll;
        list.add(root.val);

        if(root.left == null && root.right ==null){//若要包含null节点换成 或 即可
            int s = 0;
            for (Integer integer : list) {
                s += integer;
            }
            if(s == sum)
                listAll.add(new ArrayList<Integer>(list));
        }
        path_Sum(root.left,sum,listAll,list);
        path_Sum(root.right,sum,listAll,list);
        list.remove(list.size()-1);
        return listAll;
    }


    public static void main(String[] args){
        Tree tree = new Tree();
        int sum = 33;
        List<List<Integer>> listAll = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        System.out.print(pathSum(tree.root,22));
    }

    public static List<List<Integer>> path(TreeNode root,List<List<Integer>> listAll, List<Integer> list){//所有路径，不包含null节点的
        if(root == null)
            return listAll;
        list.add(root.val);
        if(root.left == null && root.right ==null){//若要包含null节点换成 或 即可
            listAll.add(new ArrayList<Integer>(list));
        }
        path(root.left,listAll,list);
        path(root.right,listAll,list);
        list.remove(list.size()-1);
        return listAll;
    }

}
