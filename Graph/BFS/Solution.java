package DSA2026.Graph.BFS;

import java.util.* ;
import java.io.*; 
public class Solution {
    static class Pair{
        int i;
        int j;
        int k;
        Pair(int i, int j, int k){
            this.i=i;
            this.j=j;
            this.k=k;
        }
    }
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        Queue<Pair> q= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(q.size()!=0){
            Pair rem=q.remove();
            int i=rem.i;
            int j=rem.j;
            int k=rem.k;
            /*
               sence the places we need to fill are only having infinite postive value 
               so it means what we need to skuip is if we are reaching any of the places twich because as we are using bfs 
               it is pretty sure that the vlaues which we have laredy fill is minimum so this is correct condition to check if (a[i][j]<=k)continue 
               or else for sure postive infinite vlaue is more than our k lookin at constrains 
               //rest of code is more or else similar to rotton oranges ok
            */
            if(a[i][j]<k )continue;
            a[i][j]=k;
            if(i>0 && a[i-1][j]==2147483647 ){
               q.add(new Pair(i-1,j,k+1));
            }
            if(j>0 && a[i][j-1]==2147483647 ){
                q.add(new Pair(i,j-1,k+1));
            }
            if(i<n-1 && a[i+1][j]==2147483647 ){
                q.add(new Pair(i+1,j,k+1));
            }
            if(j<m-1 && a[i][j+1]==2147483647 ){
                q.add(new Pair(i,j+1,k+1));
            }
        }
       return a;
    }
}
/*

? Correct Answer (for YOUR current code)

?? a[i][j] < k is correct
?? a[i][j] <= k is WRONG

?? Why <= is wrong (Important)

Remember:

Gates start with value 0

You push gates with k = 0

If you write:
if (a[i][j] <= k) continue;


Then for a gate:

a[i][j] = 0
k = 0


Condition becomes:

0 <= 0  ? true


?? Gate will be skipped
?? BFS will never expand from gates
?? Algorithm breaks
*/
