package Solutions;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        /*
         * 动态规划
         * 重点在于状态转移
         */
        int m = word1.length();
        int n = word2.length();
        int[][] ans = new int[m+1][n+1];
        for(int i=0; i<=n; i++) {
            ans[0][i] = i;
        }
        for(int i=0; i<=m; i++) {
            ans[i][0] = i;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    ans[i][j] = ans[i-1][j-1];
                } else {
                    ans[i][j] = Math.min(
                        ans[i-1][j-1],
                        Math.min(ans[i-1][j], ans[i][j-1])
                    ) + 1;
                }
            }
        }
        return ans[m][n];
    }
}
