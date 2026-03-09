package DSA2026.Graph.TOPO_Sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Course_Schedule_I {
     public boolean canFinish(int n, int[][] a) {
        int []inDegree= new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
             graph.add(i, new ArrayList<>());
        }
        for(int i=0;i<a.length;i++){
            inDegree[a[i][1]]++;
            graph.get(a[i][0]).add(a[i][1]);  
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int count=0;
        while(q.size()!=0){
            int rem=q.remove();
            count++;
            for(int x: graph.get(rem)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        return count==n;
    }
}
