package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class cycle {
      public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<=n;i++){
           graph.add(i, new ArrayList<>());
		}
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean []vis= new boolean[n+1];
        for(int i=1;i<=n;i++){
               if(!vis[i]){
                   boolean check= bfs(i,graph,vis);
                   if(check)return "Yes";
               }
        }
        return "No";
    }
    public static boolean bfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[]vis){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        while(q.size()!=0){
            int temp =q.remove();
            if(vis[temp])return true;
            vis[temp]=true;
            for(Integer a: graph.get(temp)){
                if(vis[a]==false){
                    q.add(a);
                }
            }
        }
        return false;
    }
}
