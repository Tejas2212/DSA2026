package DSA2026.Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

    public static class Pair{
        int src;
        int des;
        int wht;
        Pair(int src, int des, int wht){
            this.src=src;
            this.des=des;
            this.wht=wht;
        }
    }
    public static class PairComparator implements Comparator<Edge> {
        public int compare(Edge p1, Edge p2){
            return p1.wsf-p2.wsf;
        }
    }
    public static class Edge{
        int ver;
        String psf;
        int wsf;

        Edge(int ver, String psf, int wsf){
            this.ver= ver;
            this.psf=psf;
            this.wsf=wsf;
        }
    }
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i,new ArrayList<>());
        }
        System.out.println("Enter the graph's input");
        for(int i=0;i<e;i++){
            int src= sc.nextInt();
            int des= sc.nextInt();
            int wht=sc.nextInt();

            graph.get(src).add(new Pair(src,des,wht));
            graph.get(des).add(new Pair(des,src,wht));

            

        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(new PairComparator());
        pq.add(new Edge(0,"", 0));
        boolean []vis = new boolean[v];
        while(!pq.isEmpty()){
            Edge rem = pq.remove();
            if(vis[rem.ver]){
                continue;

            }

            vis[rem.ver]= true;
            if(rem.ver==6){
                System.out.println(rem.psf+" "+rem.wsf);
                break;
            }

            for(Pair p : graph.get(rem.ver)){
                if(!vis[p.des]){
                    pq.add(new Edge(p.des,rem.psf+p.src,rem.wsf+p.wht));
                }
            }
        }

    }
}
