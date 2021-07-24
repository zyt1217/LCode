import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JZ40 {
    public static void main(String[] args){
        int[] a = new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        System.out.print(Arrays.toString(getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8)));
        quickSelect(a,0,a.length-1,8);
        System.out.print(Arrays.toString(Arrays.copyOf(a, 8)));


    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || k>arr.length)
            return new int[0];
        ArrayList<Integer> kmin = new ArrayList<>();
        int len = arr.length;
        for (int num : arr) {
            if (kmin.size() < k) {
                kmin.add(num);
            } else {
                int max = Collections.max(kmin);
                if(num< max){
                    kmin.remove(Integer.valueOf(max));
                    kmin.add(num);
                }
            }
        }
        int[] ans = new int[kmin.size()];
        for(int i = 0; i<ans.length ; i++){
            ans[i] = kmin.get(i);
        }
        return ans;
    }

    //Top K问题，使用基于快速排序算法的快速划分
    public static void quickSort(int[] arr, int l, int r){
        //子数组长度为1时，停止递归
        if(r<=l)
            return;
        //哨兵划分操作，以arr[l]作为基准数
        int base = arr[l];
        int i = l, j = r;
        while (i<j){
            //此处的顺序必须时先移动右边，以便最后让i指向因该在左边的成员上（最后ij会重合）
            while (i<j && arr[j] >= base)
                j--;
            while (i<j && arr[i] <= base)
                i++;
            swap(arr,i,j);
        }
        swap(arr,l,i);

        //递归左右
        quickSort(arr, l ,i-1);
        quickSort(arr, i+1 ,r);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快排变形
    public static int[] quickSelect(int[] arr, int l, int r, int k){
        //哨兵划分
        int i = l, j = r;
        while (i<j){
            while (i<j && arr[j] >= arr[l])
                j--;
            while (i<j && arr[i] <= arr[l])
                i++;
            swap(arr,i,j);
        }
        swap(arr,l,i);
        //由于不需要排完，针对不同情况的k进行返回
        if(i < k)
            return quickSelect(arr, i+1, r, k);
        if(i > k)
            return quickSelect(arr, l, i-1 ,k);
        return Arrays.copyOf(arr,k);
    }
}
