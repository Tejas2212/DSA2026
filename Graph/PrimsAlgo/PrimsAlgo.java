package DSA2026.Graph.PrimsAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgo {
    public static class Edge{
        int src;
        int des;
        int wht;
        Edge(int src , int des, int wht){
            this.src=src;
            this.des=des;
            this.wht=wht;
        }
    }
    public static class Pair{
        int ver;
        int aqv;
        int wht;
        Pair(int ver, int aqv, int wht){
            this.ver=ver;
            this.aqv=aqv;
            this.wht=wht;
        }
    }
    public static class PairComparator implements Comparator<Pair>{
        public int compare(Pair p1 , Pair p2){
            return p1.wht-p2.wht;
        }
    }
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no of vertices and edges");
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i, new ArrayList<>());
        }
        System.out.println("Enter graph's input");
        for(int i=0;i<e;i++ ){
            int src=sc.nextInt();
            int des=sc.nextInt();
            int wht=sc.nextInt();
            graph.get(src).add(new Edge(src,des,wht));
            graph.get(des).add(new Edge(des,src,wht));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        boolean []vis= new boolean[v];
        pq.add(new Pair(0,-1,0));
        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            if(vis[rem.ver])continue;
            vis[rem.ver]=true;
            System.out.println(rem.ver+"is aquir by "+rem.aqv+" with cost of "+rem.wht);
            for(Edge e1: graph.get(rem.ver)){
                if(!vis[e1.des]){
                    pq.add(new Pair (e1.des,rem.ver,e1.wht));
                }
            }
        }

    }
}
