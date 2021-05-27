public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;

        boolean[] skip = new boolean[dominoes.length];
        for(int i = 0; i < dominoes.length; i++){
            if (skip[i])
                continue;
            skip[i] = true;
            int count = 0;
            for (int j = i+1; j < dominoes.length; j++){
                if(((dominoes[i][0] == dominoes[j][0])&&(dominoes[j][1] == dominoes[i][1]))
                || (dominoes[i][0] == dominoes[j][1])&&(dominoes[i][1] == dominoes[j][0])){
                    count++;
                    skip[j] = true;
                }
            }
            ans += (count * (count + 1)) >> 1;
        }
        return ans;
    }
}
