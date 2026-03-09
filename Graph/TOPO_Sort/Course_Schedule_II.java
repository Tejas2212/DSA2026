package DSA2026.Graph.TOPO_Sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Course_Schedule_II {
     public int[] findOrder(int n, int[][] a) {
        int []inDegree= new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
             graph.add(i, new ArrayList<>());
        }
        for(int i=0;i<a.length;i++){
            inDegree[a[i][0]]++;
            graph.get(a[i][1]).add(a[i][0]);  
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        int []ans = new int[n];
        while(q.size()!=0){
            int rem=q.remove();
            ans[count++]=rem;
            for(int x: graph.get(rem)){
                inDegree[x]--;
                if(inDegree[x]==0){
                    q.add(x);
                }
            }
        }
        if(count!=n)return new int[0];
        return ans;
    }
}
