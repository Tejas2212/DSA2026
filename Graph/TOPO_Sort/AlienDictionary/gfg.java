package DSA2026.Graph.TOPO_Sort.AlienDictionary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class gfg {
    public String findOrder(String[] a) {
      
        Set<Character> set= new HashSet<>();
         for(String s: a){
             for(int i=0;i<s.length();i++){
                 set.add(s.charAt(i));
             }
         }
         int n=set.size();//calculate k but still conversion to int is not possible 
         HashMap<Character,List<Character>> graph= new HashMap<>();
         HashMap<Character, Integer> inDegree= new HashMap<>();
         //graph formation
         for(Character c : set){
             graph.put(c, new ArrayList<>());
             inDegree.put(c,0);
         }
         //graph linking 
         for(int i=0;i<a.length-1;i++){
             String s1= a[i];
             String s2=a[i+1];
             // bacd 
             // bac 
             //inCorrect lexiographical order so will return from here only 
             if(s1.length()>s2.length() && s1.startsWith(s2))return "";
             
             int j=0;
             int k=0;
             while(j<s1.length() && k<s2.length() ){
                 if(s1.charAt(j)!=s2.charAt(k)){
                     graph.get(s1.charAt(j)).add(s2.charAt(k));
                     inDegree.put(s2.charAt(k),inDegree.get(s2.charAt(k)) + 1);
                     break;
                 }
                 j++;
                 k++;
             }
         }
             Queue<Character> q = new ArrayDeque<>();
             for(Character c : set){
                 if(inDegree.get(c)==0)q.add(c);
             }
             StringBuilder sb = new StringBuilder();
             while(q.size()!=0){
                 Character rem =q.remove();
                 sb.append(rem);
                 for(Character x: graph.get(rem)){
                    inDegree.put(x, inDegree.get(x)-1);
                    if(inDegree.get(x)==0)q.add(x);
                 }
             }
             //cycle if any 
             if(sb.length()!=n)return "";
             // else return our ans 
             return sb.toString();
    }
    
    /*
         Total TC	O(NL + C + E)	Graph building dominates.
    	Total SC	O(C + E)
    	
    	
    	
    	explanation 
    
    Time Complexity (TC)
    Step	Operation	Complexity	Explanation
    1	Collect unique characters	O(N × L)	Traverse every word and every character to build the set of characters.
    2	Initialize graph & indegree	O(C)	Create adjacency list and indegree for each unique character.
    3	Build graph edges	O(N × L)	Compare adjacent words and scan until the first different character.
    4	Topological Sort (BFS)	O(C + E)	Each node and edge is processed once during BFS.
    	Total TC	O(NL + C + E)	Graph building dominates.
	
	
	Space Complexity (SC)
    Structure	Complexity	Explanation
    Character set	O(C)	Stores unique characters.
    Graph (Adjacency list)	O(C + E)	Stores edges between characters.
    Indegree map	O(C)	Stores incoming edges count for each character.
    Queue (BFS)	O(C)	At most all characters can be inside queue.
    Result string	O(C)	Final alien order.
    	Total SC	O(C + E)
    
    
    */
}
