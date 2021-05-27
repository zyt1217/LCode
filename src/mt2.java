public class mt2 {
    public static void main(String args[]){
        System.out.println(move(5,3,2, new int[]{3, 2, 1, 1, 2}));


    }

    public static int move (int n,int m ,int h, int[] heights){
        for(int i = 0;i<n-m+1;i++){
            if(heights[i]<=h){
                for(int j = 1;j<=m;j++){
                    if(heights[i+j]<=h) {
                    }
                    else {
                        break;
                    }
                    return i+1;
                }
            }
        }
        return -1;
    }
}
