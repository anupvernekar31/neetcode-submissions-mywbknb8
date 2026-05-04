class Solution {
    int m, n;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // DFS from borders
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);        // left
            dfs(heights, atlantic, i, n - 1);   // right
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);        // top
            dfs(heights, atlantic, m - 1, j);   // bottom
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        for (int[] d : directions) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni < 0 || nj < 0 || ni >= m || nj >= n)
                continue;

            if (visited[ni][nj])
                continue;

            // reverse flow condition
            if (heights[ni][nj] < heights[i][j])
                continue;

            dfs(heights, visited, ni, nj);
        }
    }
}