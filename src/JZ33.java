public class JZ33 {
    public static void main(String[] args){
        int[] a = new int[]{5,4,3,2,1};
        boolean b = verifyPostorder(a);
        System.out.print(b);
    }
    public static boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 1 || postorder.length == 0)
            return true;
        int i = postorder.length -2;
        while (i != -1 && postorder[i]>postorder[postorder.length-1])
            i--;
        int[] left = new int[i+1];
        int[] right = new int[postorder.length -i-2];
        System.arraycopy(postorder,0,left,0,i+1);
        System.arraycopy(postorder,i+1,right,0,postorder.length -i-2);

        for(int l : left){
            if(l > postorder[postorder.length-1])
                return false;
        }

        return verifyPostorder(left) && verifyPostorder(right);
    }
}
