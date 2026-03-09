package DSA2026.Graph.DFS;

import java.util.ArrayList;


//Undirected Graph parent is must !!
public class CycleDetection {
        public static String cycleDetection(int[][] a, int n, int m) {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
       for(int i=0;i<n;i++){
           graph.add(i, new ArrayList<>());
       }
       for(int i=0;i<a.length;i++){
            graph.get(a[i][0]-1).add(a[i][1]-1);
            graph.get(a[i][1]-1).add(a[i][0]-1);
        }
        boolean []vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,-1,vis, graph))return "Yes";
            }
        }
        return "No";
    }
    public static boolean dfs(int i,int parent, boolean[]vis , ArrayList<ArrayList<Integer>>graph){
        vis[i]=true;
        for(Integer x: graph.get(i)){
            if(!vis[x]){
               if(dfs(x,i,vis, graph))return true;
            }else if(x!=parent)return true;
        }
        return false;
    }
}
