package DSA2026.Graph.DFS;
//read the notes below 
import java.util.ArrayList;

class Solution {
    public int findCircleNum(int[][] mat) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int v= mat.length;
        for(int i=0;i<v;i++){
            graph.add(i , new ArrayList<>()); //O(v)
        }
        for(int i=0;i<mat.length;i++){ //O(v^2)
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1 && j!=i){
                  graph.get(i).add(j);
                }
            }
        }
       int ans =0;
       boolean []vis= new boolean[v];
       for(int i=0;i<v;i++){ // O(v)
          if(vis[i]==false){
            ans++;
            dfs(i , vis , graph);
          }
       }
        return ans;
    }
    public void dfs(int i, boolean[] vis , ArrayList<ArrayList<Integer>> graph){
        // O(2e)
        if(vis[i])return ;
        vis[i]=true;
        for(Integer a: graph.get(i)){
            if(vis[a]==false){
                dfs(a,vis, graph);
            }
        }
    }
}

// O(v)+O(v^2)+O(V)+O(2E)
// = O(2v+2e)+O(v^2)
// = O(v+e)+O(v^2) //In b O notations we can exclude constants 
// =O(v^2)

/*
   | Approach               | Time      | Space      |
| ---------------------- | --------- | ---------- |
| Adj list + DFS (yours) | O(n²)     | O(n²)      |
| Matrix DFS             | **O(n²)** | **O(n)** ✅ |
| Union-Find             | O(n²)     | O(n)       |


//only thing we can optimised is space 

 */