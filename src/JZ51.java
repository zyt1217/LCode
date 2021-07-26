import java.util.Arrays;

public class JZ51 {
    int[] tmp;

    public static void main(String[] args){
        int[] nums = new int[]{2,4,6,1,5,3,9,8};
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1,tmp);
        System.out.print(Arrays.toString(nums));
    }
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        int len = nums.length;
        return mergeSort_withCount(nums, 0, len -1);
    }

    public int mergeSort_withCount(int[] nums, int l, int r){
        if(l >= r)
            return 0;
        int mid = (l+r)/2;
        int res = mergeSort_withCount(nums, l, mid) + mergeSort_withCount(nums, mid+1, r);
        //递归之后的内容是回溯的过程...

        //每次归并排序的时候都要进行暂存
        System.arraycopy(nums, 0, tmp, 0, tmp.length);
        //接下来的num[i]仅用来填入排序的数，而暂存的tmp[i]在这一轮进行比较；
        int i = l, j = mid+1;
        for (int k = l; k<=r; k++){
            if(i == mid + 1){
                nums[k] = tmp[j];
                j++;
            }else if(j == r + 1 || tmp[i] <= tmp[j]){
                nums[k] = tmp[i];
                i++;
            }else {
                nums[k] = tmp[j];
                j++;
                //遇到逆序的，有多少个？ tmp[i] > tmp[j], 那么 i比j以及之前的数都大，
                //但这些数已经被操作，而i之后的所有数都比j大，一共有m-i+1个数还需要被操作，
                //之后j被移动到j+1，此时暂不知道j+1与i的关系，
                //这里表示逆序关系是对于j而言的
                res += mid - i + 1;
            }
        }
        return res;
    }

    //归并排序
    public static void mergeSort(int[] nums, int l, int r, int[] tmp){
        //终止条件
        if(l >= r)
            return;
        int m = (l+r)>>1;
        //先分治，递归
        mergeSort(nums, l, m, tmp);
        mergeSort(nums, m+1, r, tmp);
        //递归之后的内容是回溯的过程...

        //每次归并排序的时候都要进行暂存
        System.arraycopy(nums, 0, tmp, 0, tmp.length);
        int i = l, j = m + 1;
        for(int k = l; k <= r; k++){
            if(i > m)
                nums[k] = tmp[j++];
            else if(j > r)
                nums[k] = tmp[i++];
            else if(tmp[i]<=tmp[j])
                nums[k] = tmp[i++];
            else nums[k] = tmp[j++];
        }
    }

}
