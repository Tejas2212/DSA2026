package DSA2026.Graph.BFS;
import java.util.*;


class Solution {
    class Pair{
        int src;
        int level;
        Pair(int src, int level){
            this.src=src;
            this.level=level;
        }
    }
    public boolean isBipartite(int[][] edge) {
        int n =edge.length;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<n;i++){
		    graph.add(i,new ArrayList<>());
		}
		for(int i=0;i<n;i++){
		  for(int a: edge[i]){
		      graph.get(i).add(a);
		  }
		}
		int []vis = new int[n];
        Arrays.fill(vis,-1);
		for(int i=0;i<n;i++){
		  if(vis[i]==-1){
		     boolean flag=isGraphBipartite(i ,vis, graph );
			 if(!flag)return false;
		  }
		}
		return true;
    }
	public boolean isGraphBipartite(int src, int[]vis ,ArrayList<ArrayList<Integer>> graph){
	  Queue<Pair> q = new ArrayDeque<>();
	  q.add(new Pair(src,0));
	  
	  while(q.size()!=0){
        Pair rem= q.remove();
		  if(vis[rem.src]!=-1 && rem.level!=vis[rem.src]){
		    return false;
		  }else if(vis[rem.src]!=-1){
		     continue;
		  }      
          vis[rem.src]=rem.level; 
		  for(int a : graph.get(rem.src)){
		     if(vis[a]==-1){
			    q.add(new Pair(a, rem.level+1));
			 }
		  } 
	  }
	  return true; 
	}
}