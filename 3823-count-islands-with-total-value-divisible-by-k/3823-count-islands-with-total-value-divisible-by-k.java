class Solution {
    int m, n;
    int[][] grid;
    int[] dir = {-1, 0, 1, 0, -1};

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(i, j);

                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    private long dfs(int i, int j) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        for (int d = 0; d < 4; d++) {
            int x = i + dir[d];
            int y = j + dir[d + 1];

            if (x >= 0 && x < m &&
                y >= 0 && y < n &&
                grid[x][y] > 0) {
                sum += dfs(x, y);
            }
        }

        return sum;
    }
}