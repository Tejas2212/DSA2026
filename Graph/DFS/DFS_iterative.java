package DSA2026.Graph.DFS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS_iterative {
    //why iterative dfs
    // ans is simple in recursive dfs we used recursion
    // stack (stack) memory which fail for nodes more tha 10to the power 5
    //here we used simple heap space where limitation is not there memory out of stack can be avoided
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no of vertices and no of edges");
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(i , new ArrayList<>());
        }
        System.out.println("Enter graph's input");
        for(int i=0;i<e;i++){
            int src=sc.nextInt();
            int des=sc.nextInt();
            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        Stack<Integer> st = new Stack<>();
        st.add(0);
        boolean []vis = new boolean[v];
        while(!st.isEmpty()){
            int rem =st.pop();
            if(vis[rem])continue;
            vis[rem]=true;
            System.out.print(rem+"->");
            for(Integer a:graph.get(rem)){
                if(!vis[a]){
                    st.add(a);
                }
            }
        }
    }
}