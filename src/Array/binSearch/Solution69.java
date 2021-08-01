package Array.binSearch;

public class Solution69 {
    public int mySqrt(int x) {
        int res = 0;
        if(x == 1)
            return 1;
        for(int i = 0;i<=x/2+1;i++){
            if((long)i*i>x){
                res = i-1;
                break;
            }

        }
        return res;
    }

    public int mySqrtBSearch(int x){// 有有序结构的时候，就可以用二分查找
        int res = 0;
        int l = 0, r = x;
        while(l<=r){
            int mid = (r-l)/2 + l;
            if((long)mid*mid > x ){
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return l;

    }
}
