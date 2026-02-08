package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> a) {
       Queue<Integer> q= new ArrayDeque<>();
	   ArrayList<Integer> ans = new ArrayList<>();
	   q.add(0);
	   boolean [] vis = new boolean[a.size()];
	   while(q.size()!=0){
	     int temp =q.remove();
		 if(vis[temp])continue;
		 vis[temp]=true;
		 ans.add(temp);
		 for(Integer i: a.get(temp)){
		   if(vis[i]==false){
		    q.add(i);
		   }
		  }
	   }
	   return ans;
    }
}
