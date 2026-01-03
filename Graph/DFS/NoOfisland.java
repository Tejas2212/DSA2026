package DSA2026.Graph.DFS;

class Solution {

//they have not gives us edges direclt but yes we can travel S,N,E,W
//which means we have edges virual edges 
    public int numIslands(char[][] a) {
		int n= a.length;
		int m =a[0].length;
		boolean [][]vis = new boolean[n][m];//default value will be false on all vertices 
		int count=0;
		for(int i=0;i< n;i++){
		  for(int j=0;j<m;j++){
		    if(vis[i][j]==false){
			dfs(i,j,vis, a);
			  count++;
			}
		  }
		
		}
        return count;
		
    }
	public void dfs(int i , int j , boolean[][]vis, char[][]a){
	//reactive recursion call whwre after doing calls of dfs we are checking them at base condtion 
	   if(i<0 || j<0 || i>=a.length || j>=a[0].length || vis[i][j] || a[i][j]==1){
	      return;
	   }
	   
	   vis[i][j]=true;
	   
	   
	   dfs(i-1,j,vis,a);
	   dfs(i,j-1,vis,a);
	   dfs(i+1,j,vis,a);
	   dfs(i,j+1,vis,a);
	
	}
}


//two major mistake in code 
//boolean [] insted boolean[][]
// = insted of == in if condition 
//a is char array not an integer array 
//missing return statement 





// Code without extra visted array space 
//2d graph might not required extra space always think about it 


class Solution {
    public int numIslands(char[][] a) {
		int n= a.length;
		int m =a[0].length;
		int count=0;
		for(int i=0;i< n;i++){
		  for(int j=0;j<m;j++){
		    if(a[i][j]=='1'){
			  dfs(i,j, a);
			  count++;
			}
		  }
		
		}
        return count;
		
    }
	public void dfs(int i , int j ,  char[][]a){
	   if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]=='0'){
	      return;
	   }
	  a[i][j]='0';
	   dfs(i-1,j,a);
	   dfs(i,j-1,a);
	   dfs(i+1,j,a);
	   dfs(i,j+1,a);
	}
}