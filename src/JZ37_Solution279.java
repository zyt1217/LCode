import java.util.LinkedList;
import java.util.Queue;

public class JZ37_Solution279 {

    public static void main(String[] args){
        Codec a = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        a.deserialize(a.serialize(root));
        //a.serialize(a.deserialize("[1,2,3,null,null,4,5,null,null,null,null]"));
    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null)
                return "[]";
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){//同样也可以用队列，队列元素类型是节点，可以存储null节点
                TreeNode out = queue.poll();
                if(out!=null) {
                    res.append(String.valueOf(out.val) + ',');
                    queue.add(out.left);
                    queue.add(out.right);
                }
                else res.append("null,");
            }
            res.deleteCharAt(res.length()-1);
            res.append(']');
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("[]"))
                return null;
            String[] vals = data.substring(1,data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()){
                TreeNode out = queue.poll();
                if(!vals[i].equals("null")){
                    out.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(out.left);
                }//else do nothing, 直接过i
                i++;
                if(!vals[i].equals("null")){
                    out.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(out.right);
                }//else do nothing, 直接过i
                i++;
            }
            return root;
        }
    }
}
