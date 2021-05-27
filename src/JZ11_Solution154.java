public class JZ11_Solution154 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if(len == 1)
            return numbers[0];
        if(len == 2)
            return Math.min(numbers[0],numbers[1]);
        int[] newnums;
        int mid = len/2;
        if(numbers[0]>numbers[mid]) {
            newnums = new int[mid];
            System.arraycopy(numbers,1,newnums,0,mid);
            return minArray(newnums);
        }
        if(numbers[mid]>numbers[len-1]){
            newnums = new int[len-1-mid];
            System.arraycopy(numbers,mid+1,newnums,0,len-1-mid);
            return minArray(newnums);
        }
        newnums = new int[len-1];
        System.arraycopy(numbers,0,newnums,0,len-1);
        return minArray(newnums);
    }
}
