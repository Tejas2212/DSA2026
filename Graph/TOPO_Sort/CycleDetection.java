package DSA2026.Graph.TOPO_Sort;
import java.util.*;
public class CycleDetection {
  public static boolean detectCycleInDirectedGraph(int v, ArrayList < ArrayList < Integer >> edges) {
   int []inDegree = new int[v];
        int count=0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i,new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
           graph.get(edges.get(i).get(0)-1).add(edges.get(i).get(1)-1);
           inDegree[edges.get(i).get(1)-1]++;
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<v;i++){
          if(inDegree[i]==0){
              q.add(i);
          }
        }
        while(q.size()!=0){
            int rem=q.remove();
            count++;
            for(Integer x: graph.get(rem)){
                inDegree[x]--;
                if(inDegree[x]==0)q.add(x);
            }
        }
        return count==v?false:true;
        //count==v shows topo is applicable means no cycle as topo is applicable on DAG
         
  }
}