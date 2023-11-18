class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int INF = 1_000_000_007;
        
        int[][] dp = new int[n][m];
        
        for (int[] item: puddles) {
            dp[item[1] - 1][item[0] - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1 || i == 0 && j == 0) {
                    continue;
                }
                
                
                
                if (i == 0 && dp[i][j - 1] == -1) {
                    dp[i][j] = -1;
                    continue;
                } else if (i == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if (j == 0 && dp[i - 1][j] == -1) {
                    dp[i][j] = -1;
                    continue;
                } else if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
                    dp[i][j] = -1;
                } else if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j];
                    
                } else if (dp[i - 1][j] == -1){
                    dp[i][j] = dp[i][j - 1]; 
                    dp[i][j] %= INF;
                } else if (dp[i][j] == -1){
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                   
                }
                 dp[i][j] %= INF;
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return dp[n - 1][m - 1] == -1 ? 0 :dp[n - 1][m - 1];
    }
}