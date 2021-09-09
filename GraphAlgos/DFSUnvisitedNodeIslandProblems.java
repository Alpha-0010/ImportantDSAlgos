// Leetcode Problem: Number Of Islands...

// DFS Application...
class Solution {
    int[][] dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                   dfs(grid,i,j,n,m);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid,int i,int j,int n,int m){
        grid[i][j]='0';
        
        for(int[] dir : dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || y<0 || x>=n || y>=m || grid[x][y]=='0'){
                continue;
            }
            dfs(grid,x,y,n,m);
        }
    }
    
}