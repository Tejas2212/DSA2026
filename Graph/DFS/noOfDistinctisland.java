package DSA2026.Graph.DFS;

import java.util.*;
public class noOfDistinctisland 
{
	public static class Pair{
		int i;
		int j;
		Pair(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
	public static int distinctIsland(int [][] a, int n, int m) 
	{
		boolean[][]vis= new boolean[n][m];
		Set<ArrayList<String>> set = new HashSet<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
                 if(a[i][j]==1 && vis[i][j]==false){
					 Pair base = new Pair(i,j);
					ArrayList<String> temp= bfs( i,  j, vis, a, base);
				    Collections.sort(temp);
					set.add(temp);
				 }
			}
		}
      return set.size();
	}
	public static ArrayList<String> bfs(int ii, int jj , boolean[][]vis , int[][]a, Pair base){
       Queue<Pair> q= new ArrayDeque<>();
	   ArrayList<String> list= new ArrayList<>();
	   q.add(new Pair(ii,jj));
	   while(q.size()!=0){
         Pair rem =q.remove();
		 int i=rem.i;
		 int j=rem.j;
		 if(vis[i][j])continue;
		 vis[i][j]=true;
		 String s = (i - base.i) + " " + (j - base.j);
		 list.add(s);
		 if(i>0 && vis[i-1][j]==false && a[i-1][j]==1){
			 q.add(new Pair(i-1,j));
		 }
		 if(j>0 && vis[i][j-1]==false && a[i][j-1]==1){
			 q.add(new Pair(i,j-1));
		 }
		 if(i<a.length-1 && vis[i+1][j]==false && a[i+1][j]==1){
			 q.add(new Pair(i+1,j));
		 }if(j<a[0].length-1 && vis[i][j+1]==false && a[i][j+1]==1){
			 q.add(new Pair(i,j+1));
		 }
	   }
	   return list;
	}
}

