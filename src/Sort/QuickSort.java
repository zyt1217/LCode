package Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] a, int l, int r){
        if(r<=l)
            return;

        int i = l, j = r;
        while (i<j){
            while (i<j && a[l] < a[j])
                j--;
            while (i<j && a[l] > a[i])
                i++;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        quickSort(a,l,i-1);
        quickSort(a,i+1,r);
    }
}

class test{
    public static void main(String[] args){
        int[] a = new int[]{1,2,5,3,7,9,8,12,10,22,57,45,33,29};
        QuickSort q = new QuickSort();
        q.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}