import java.util.ArrayList;
import java.util.LinkedList;

public class mt1 {

    public static void main(String args[]){
        int a = s(5,4,3,new int[]{1,1,2,2,1},new int[]{1,1,5,4,4},new int[]{2,2,5,4,1});
        System.out.println(a);
    }

    public static int s (int n,int m,int k,int[]... cells){
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<cells.length;i++){
            if(cells[i][0] == 1 && cells[i][1] == 1){
                int j = i;
                int len = cells[i][4];
                int[] tempcell = cells[i];
                while(tempcell[2] != n && tempcell[3] != m){
                    int findflag = 0;
                    for(int l = 0; l<cells.length;l++){
                        if(cells[l][0] == tempcell[2] && tempcell[3] == cells[l][1]){
                            findflag ++;
                            len = len +  cells[l][4];
                            tempcell = cells[l];
                        }
                    }
                    if(findflag == 0)
                        return -1;
                }
                min = Math.min(min,len);
            }
        }
        return min;
    }
}
