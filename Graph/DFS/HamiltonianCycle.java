package DSA2026.Graph.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class HamiltonianCycle {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input for graph no of vertices and number of edges ");
        int v= sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i, new ArrayList<>());
        }
        System.out.println("Enter graph's input");
        for(int i=0;i<e;i++){
            int src= sc.nextInt();
            int des = sc.nextInt();
            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        //why hasset many of the operations works in O(1)
        HashSet<Integer> set = new HashSet<>();
        printHamiltonianCycleandPaths(0,""+0, graph ,0 ,set);
    }
    public static void printHamiltonianCycleandPaths(int src, String psf, ArrayList<ArrayList<Integer>> graph , int orgSrc, HashSet<Integer> set){

        if(set.size()==graph.size()-1){

            if(graph.get(src).contains(orgSrc)){
                System.out.println("Hamiltonian Cycle -> "+ psf);
            }else {
                System.out.println("Hamiltonian Path  ->"+psf);
            }
        }

        set.add(src);
        for(Integer a: graph.get(src)){
            if(!set.contains(a)){
                printHamiltonianCycleandPaths(a,psf+" "+a, graph,orgSrc,set);
            }
        }
        set.remove(src);
    }
}

