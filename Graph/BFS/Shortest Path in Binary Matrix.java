package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
 class Pair{
    int i;
	int j;
	int k;
	Pair(int i, int j , int k){
	  this.i=i;
	  this.j=j;
	  this.k=k;
	}
 }
    public int shortestPathBinaryMatrix(int[][] a) {
        if(a[0][0]==1)return -1;
		int n=a.length;
		int m=a[0].length;
		int [][]ans = new int[n][m];
		for(int i=0;i<n;i++){
		  for(int j=0;j<m;j++){
		    ans[i][j]=-1;
		  }
		}
		Queue<Pair> q= new ArrayDeque<>();
		q.add(new Pair(0,0,1));
		while(q.size()!=0){
		  Pair rem =q.remove();
		  int i=rem.i;
		  int j=rem.j;
		  int k=rem.k;
		  if(ans[i][j]!=-1)continue;
		  ans[i][j]=k;
		  
		  if(i>0&&a[i-1][j]==0 && ans[i-1][j]==-1){
		    q.add(new Pair(i-1,j,k+1));
		  }
		  if(j>0&&a[i][j-1]==0 && ans[i][j-1]==-1){
		    q.add(new Pair(i,j-1,k+1));
		  }
		  if(i<n-1&&a[i+1][j]==0 && ans[i+1][j]==-1){
		    q.add(new Pair(i+1,j,k+1));
		  }
		  if(j<m-1&&a[i][j+1]==0 && ans[i][j+1]==-1){
		    q.add(new Pair(i,j+1,k+1));
		  }
		  if(i>0&& j>0&& a[i-1][j-1]==0 && ans[i-1][j-1]==-1){
		    q.add(new Pair(i-1,j-1,k+1));
		  }
		  if(i>0&& j<m-1&& a[i-1][j+1]==0 && ans[i-1][j+1]==-1){
		    q.add(new Pair(i-1,j+1,k+1));
		  }
		   if(i<n-1&& j>0&& a[i+1][j-1]==0 && ans[i+1][j-1]==-1){
		    q.add(new Pair(i+1,j-1,k+1));
		  }
		  if(i<n-1&& j<m-1&& a[i+1][j+1]==0 && ans[i+1][j+1]==-1){
		    q.add(new Pair(i+1,j+1,k+1));
		  }
		}
		return ans[n-1][m-1];
    }
}