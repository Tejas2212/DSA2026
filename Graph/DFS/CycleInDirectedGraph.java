package DSA2026.Graph.DFS;

import java.util.ArrayList;

public class CycleInDirectedGraph {
     public boolean isCyclic(int v, int[][] a) {
        // code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i, new ArrayList<>());
        }
        boolean []vis= new boolean[v];
        boolean[] pathVis= new boolean[v];
        for(int i=0;i<a.length;i++){
            //directed graph
            graph.get(a[i][0]).add(a[i][1]);
        }
        for(int i=0;i<v;i++){
            if(dfs(i,vis, pathVis, graph))return true;
        }
        return false;
    }
    public boolean dfs(int i , boolean []vis , boolean[]pathVis, ArrayList<ArrayList<Integer>> graph){
        vis[i]=true;
        pathVis[i]=true;
        for(Integer x :graph.get(i)){
            if(vis[x]==false){
                if(dfs(x, vis, pathVis, graph))return true;
            }else if(pathVis[x])return true;
        }
        //if no more nbr of the current vertex remove it from path vis 
        pathVis[i]=false;
        return false;
    }
}
