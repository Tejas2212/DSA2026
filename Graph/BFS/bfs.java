package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class bfs {
        public static void bfsTraversal(int src,  ArrayList<ArrayList<Integer>> graph, boolean []vis){
        Queue<Integer> q= new ArrayDeque<>();
        q.add(src);

        while(!q.isEmpty()){
            int a= q.remove();
            if(vis[a]){
                continue;
            }
            vis[a]=true;
            System.out.println(a+" ");
            for(Integer temp : graph.get(a)){
                q.add(temp);
            }
        }
    }
}
