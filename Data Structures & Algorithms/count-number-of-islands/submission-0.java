class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public void bfs(int ro, int co, char[][] grid, int[][] vis){
        int n= grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        vis[ro][co] = 1;
        q.add(new Pair(ro, co));
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = { 0, 1, 0, -1};
            
                for(int i=0;i<4;i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow >=0 && nrow< n && ncol >=0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int [][]vis = new int[n][m];
        int count = 0;
        
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col] == '1' && vis[row][col] == 0){
                    count++;
                    bfs(row, col, grid, vis);
                }
            }
        }
        return count;
        
    }
}