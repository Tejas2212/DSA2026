package DSA2026.Graph.DFS;

class Solution {
    public int numEnclaves(int[][] a) {
        for(int i=0;i<a.length;i++){
            if(a[i][0]==1)dfs(a,i,0);
        }for(int j=1;j<a[0].length;j++){
            if(a[0][j]==1)dfs(a,0,j);
        }for(int i=1;i<a.length;i++){
            if(a[i][a[0].length-1]==1)dfs(a,i,a[0].length-1);
        }for(int j=1;j<a[0].length-1;j++){
            if(a[a.length-1][j]==1)dfs(a,a.length-1,j);
        }
      int count=0;
      for(int []temp:a){
        for(int x:temp){
            if(x==1)count++;
        }
      }
      return count;
    }
    public void dfs(int [][]a, int i, int j){

        if(i<0 ||j<0 ||i>=a.length || j>=a[0].length ||a[i][j]!=1)return;
        a[i][j]=0;
        dfs(a,i-1,j);
        dfs(a,i+1,j);
        dfs(a,i,j-1);
        dfs(a,i,j+1);
    }
}
