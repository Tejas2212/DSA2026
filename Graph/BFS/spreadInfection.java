package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class spreadInfection {
    public static void main(String []args){

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no of vertices and edges in graph");
        int v =sc.nextInt();
        int e= sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i , new ArrayList<>());
        }
        System.out.println("Enter graph's input");
        for(int i=0;i<e;i++){
            int src= sc.nextInt();
            int des =sc.nextInt();

            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        int start= sc.nextInt();
        int time = sc.nextInt();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, 1));
        int count =0;
        int []vis = new int[v];
        while(!q.isEmpty()){
            Pair rem =q.remove();
            if(rem.time >time)break;
            if(vis[rem.src]>0)continue;

            vis[rem.src]= time;
            count++;
            for(Integer a: graph.get(rem.src)){
                if(vis[a]==0){
                    q.add(new Pair(a, rem.time+1));
                }
            }
        }
        System.out.println(count);

    }

    static class Pair{
        int src;
        int time;
        Pair(int src, int time){
            this.src=src;
            this.time=time;
        }
    }
}