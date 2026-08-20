class Solution {

    /*

    ==========================
    MEMOIZATION
    ==========================
    public int findways(int row, int col, int m, int n, int dp[][]){
        if( row == 0 && col ==0){
            return 1;
        }
        if (row < 0 || col < 0)
            return 0;

        if(dp[row][col]!=-1)return dp[row][col];

        int left = findways(row, col-1, m,n, dp);
        int up = findways(row-1, col, m, n, dp);
        return dp[row][col] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int [m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return findways(m-1, n-1, m, n, dp );
        
    }

    */

    // ==========================
    // TABULATION
    // ==========================

    int func(int m, int n, int[][] dp) {
        // Loop through the grid using two nested loops
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base condition
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue; 
                }

                int up = 0;
                int left = 0;

                // Check cell above
                if (i > 0)
                    up = dp[i - 1][j];

                // Check cell to the left
                if (j > 0)
                    left = dp[i][j - 1];

                // Total ways to reach this cell
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    // Function to count total ways
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return func(m, n, dp);
    }
}