package DSA2026.Graph.DFS;

import java.util.ArrayList;

class Solution {
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
       
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean []vis = new boolean[V];
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
        for(int i=0;i<V;i++){
            
            if(!vis[i]){
                ArrayList<Integer> ans = new ArrayList<>();
                dfs(i, vis , graph , ans );
                fans.add(ans);
            }
        }
        return fans;
    }
    public void dfs(int src, boolean[]vis ,ArrayList<ArrayList<Integer>> graph , ArrayList<Integer> ans){
        vis[src]= true;
        ans.add(src);
        for(Integer a : graph.get(src)){
            if(vis[a]==false){
                dfs(a, vis , graph , ans);
            }
        }
        
    }
}