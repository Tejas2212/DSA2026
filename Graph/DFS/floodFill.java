package DSA2026.Graph.DFS;

class Solution {
    public int mainColor;
    public int color;
    public int[][] floodFill(int[][] a, int sr, int sc, int clr) {
        mainColor=a[sr][sc];
        color=clr;
        if(mainColor==color)return a;
        dfs(sr,sc,a);
        return a;
    }
    public void dfs(int i , int j, int [][]a){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]!=mainColor)return;
        a[i][j]=color;
        dfs(i-1,j,a);
        dfs(i+1,j,a);
        dfs(i,j-1,a);
        dfs(i,j+1,a);
    }
}
