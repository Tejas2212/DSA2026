package DSA2026.Graph.DFS;

class Solution {
    public boolean dfs(int i, int j, char mainChar, boolean[][] vis,
                   char[][] a, int previ, int prevj) {

    if (i < 0 || j < 0 || i >= a.length || j >= a[0].length)
        return false;

    if (a[i][j] != mainChar)
        return false;

    if (vis[i][j])
        return true;

    vis[i][j] = true;

    // Explore neighbors but SKIP parent
    if (!(i - 1 == previ && j == prevj))
        if (dfs(i - 1, j, mainChar, vis, a, i, j)) return true;

    if (!(i + 1 == previ && j == prevj))
        if (dfs(i + 1, j, mainChar, vis, a, i, j)) return true;

    if (!(i == previ && j - 1 == prevj))
        if (dfs(i, j - 1, mainChar, vis, a, i, j)) return true;

    if (!(i == previ && j + 1 == prevj))
        if (dfs(i, j + 1, mainChar, vis, a, i, j)) return true;

    return false;
}
    public boolean containsCycle(char[][] a) {
        int n=a.length;
        int m=a[0].length;

        boolean [][]vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false)
                if(dfs(i, j,a[i][j], vis,a,i-1,j-1))return true;
            }
        }
        return false;
        
    }
}
