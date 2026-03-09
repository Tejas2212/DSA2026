package DSA2026.Graph.TOPO_Sort;

import java.util.*;

class Solution {
    public ArrayList<Integer> topoSort(int v, int[][] a) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	   for(int i=0;i<v;i++){
	      graph.add(i, new ArrayList<>());
	   }
	   for(int i=0;i<a.length;i++){
	     graph.get(a[i][0]).add(a[i][1]);
	   }
	   boolean []vis =new boolean[v];
	   Stack<Integer> st = new Stack<>();
       for(int i=0;i<v;i++){
	      if(!vis[i]){
		     dfs(i,st,vis,graph);
		  }
	   } 
	   ArrayList<Integer> ans = new ArrayList<>();
	   while(st.size()!=0){
	     ans.add(st.pop());
	   }
	   return ans;
    }
	private void dfs(int i, Stack<Integer>st , boolean []vis , ArrayList<ArrayList<Integer>> graph){
	   vis[i]=true; 
	   for(Integer x: graph.get(i)){
	      if(!vis[x]){
		     dfs(x,st,vis,graph);
		  }
	   }
	   st.add(i);
	   return ;	
	}
}
