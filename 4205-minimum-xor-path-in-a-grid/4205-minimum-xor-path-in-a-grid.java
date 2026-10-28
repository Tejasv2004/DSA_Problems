class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] dp = new boolean[n][1024];
        dp[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                boolean[] cur = new boolean[1024];

                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[j][x]) {
                            cur[x ^ grid[i][j]] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (dp[j - 1][x]) {
                            cur[x ^ grid[i][j]] = true;
                        }
                    }
                }

                dp[j] = cur;
            }
        }

        for (int x = 0; x < 1024; x++) {
            if (dp[n - 1][x]) return x;
        }

        return -1;
    }
}