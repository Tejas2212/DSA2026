package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

//Done two small mistakes addingeveryinh in queue at start we should add index where a[i][j]=2
// vis[i][j] but cndtion should be vis[i][j]!=0 as vis is int array 
class Solution {
  class Pair{
    int i;
	int j;
	int level;
	Pair(int i, int j, int level){
	  this.i=i;
	  this.j=j;
	  this.level=level;
	}
  }
    public int orangesRotting(int[][] a) {
        Queue<Pair> q= new ArrayDeque<>();
		int n=a.length;
		int m=a[0].length;
		int [][]vis= new int[n][m];
		for(int i=0;i<n;i++){
		 for(int j=0;j<m;j++){
            if(a[i][j]==2)
		    q.add(new Pair(i,j,0));
		 }
		}
		
		while(q.size()!=0){
		   Pair rem=q.remove();
		   int i=rem.i;
		   int j=rem.j;
		   int level=rem.level;
		   
		   if(vis[i][j]!=0)continue;
		   vis[i][j]=level;
		   
		   if(i>0 && a[i-1][j]==1 &&vis[i-1][j]==0){
		      q.add(new Pair(i-1,j,level+1));
		   }
		   if(j>0 && a[i][j-1]==1 &&vis[i][j-1]==0){
		      q.add(new Pair(i,j-1,level+1));
		   }
		   if(i<n-1 && a[i+1][j]==1 &&vis[i+1][j]==0){
		      q.add(new Pair(i+1,j,level+1));
		   }
		   if(j<m-1 && a[i][j+1]==1 &&vis[i][j+1]==0){
		      q.add(new Pair(i,j+1,level+1));
		   }  
		}
		int ans=0;
		for(int i=0;i<n;i++){
		 for(int j=0;j<m;j++){
		    if(a[i][j]==1 && vis[i][j]==0)return -1;
			ans= vis[i][j]> ans ? vis[i][j]:ans;
		 }
		
		}
		return ans;
    }
}


// //more optimised without error 

// //space is optmised time is alredy optmised 

// class Solution {
//     class Pair {
//         int i;
//         int j;
//         int level;

//         Pair(int i, int j, int level) {
//             this.i = i;
//             this.j = j;
//             this.level = level;
//         }
//     }

//     public int orangesRotting(int[][] a) {
//         Queue<Pair> q= new ArrayDeque<>();// O(n*n) spaceif all values are 2
// 		int n=a.length;
// 		int m=a[0].length;	
// 		for(int i=0;i<n;i++){//O(n*n)
// 		 for(int j=0;j<m;j++){
//             if(a[i][j]==2){
//               	q.add(new Pair(i,j,0));
//             }
// 		  }
// 		}
//         int ans=0;
//         //O(1) below while loop 
// 		while (q.size() != 0) {
//     Pair rem = q.remove();          // O(1)
//     int i = rem.i;
//     int j = rem.j;
//     int level = rem.level;

//     if (a[i][j] == 2 && level != 0) continue;  // O(1)

//     ans = ans > level ? ans : level;           // O(1)
//     a[i][j] = 2;                               // O(1)

//     // 4 directional checks
//     if (i > 0 && a[i-1][j] == 1) q.add(...);
//     if (j > 0 && a[i][j-1] == 1) q.add(...);
//     if (i < n-1 && a[i+1][j] == 1) q.add(...);
//     if (j < m-1 && a[i][j+1] == 1) q.add(...);
// }

// 		for(int i=0;i<n;i++){  //O(n*n)
// 		 for(int j=0;j<m;j++){
// 		    if(a[i][j]==1)return -1;
// 		 }
// 		}
// 		return ans;
//     }
// }
// Time complexity is O(n×m) and space complexity is O(n×m) due to the BFS queue. We optimize space by not using an extra visited matrix
