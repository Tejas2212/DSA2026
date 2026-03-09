package DSA2026.Graph.TOPO_Sort;

import java.util.*;
import java.io.*;

public class bfsTopo {
    // sence bfs so Queue
    // inDegree[0] shoes no outgoing edges if no outgoing edges we can add it in ans
    // as topo sort says if there is edge between u->v u must appear bebore v
    // so if inDegree is zero denotes v does not have any edge and we can add it to
    // ans
    // once we add it in ans all it's nbr inDegree will be reduceby because that
    // perticular vertetx
    // effect is ended
    // Thanks
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        int[] inDegree = new int[v];
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            inDegree[edges.get(i).get(1)]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (q.size() != 0) {
            int rem = q.remove();
            ans.add(rem);
            for (Integer x : graph.get(rem)) {
                inDegree[x]--;
                if (inDegree[x] == 0)
                    q.add(x);
            }
        }
        return ans;
    }
}
