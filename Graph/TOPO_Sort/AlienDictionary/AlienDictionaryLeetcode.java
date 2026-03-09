package DSA2026.Graph.TOPO_Sort.AlienDictionary;

import java.util.*;
public class AlienDictionaryLeetcode {

    private static void topo(int i, boolean []vis , ArrayList<ArrayList<Integer>> graph , Stack<Integer>st){
        vis[i]=true;
        for(Integer x: graph.get(i)){
            if(vis[x]==false){
                topo(x,vis,graph,st);
            }
        }
        st.add(i);
        return ;
    }
    public static String getAlienLanguage(String []s, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<k;i++){
            graph.add(i , new ArrayList<>());
        }
        for(int i=0;i<s.length-1;i++){
            String s1=s[i];
            String s2=s[i+1];

            if(s1.length()>s2.length()&& s1.startsWith(s2))return "";///base condition one 
            int j=0; 
            int l=0; 
            while(j<s1.length() && l<s2.length() ){
                if(s1.charAt(j)!=s2.charAt(l)){
                    //any arthmatic operation to char will try to convert it to ineteger 
                    //we have learn where typecasting is required and where it will be done automaticaly 
                    //in java 
                    graph.get(s1.charAt(j)-97).add(s2.charAt(l)-97);
                    break;
                }
                j++;
                l++;
            }
        }
        StringBuilder sb= new StringBuilder();
        Stack<Integer> st= new Stack<>();
        boolean []vis = new boolean[k];
        for(int i=0;i<k;i++){
            if(vis[i]==false){
               topo(i,vis, graph,st);
            }
        }
        if(st.size()!=k)return "";
        //cycle if cycle return empty string as expected  this will nto work in dfs 
        /*
        
        
        sence we are using dfs this condition will not work for cycle detection 
        this is perfect for bfs but for dfs we need pathVis 
        but see in question it is mention that there will no cycle that's why it is working 


        //always prefer bfs over dfs 
        //alwys 

        
        */

       while(st.size()!=0){
           int x=st.pop();    
           //conversion is very very imp ()() both bracnktes   
           sb.append((char)(x+97));
       }
       return sb.toString();
    }
}