package DSA2026.Graph.DFS;

import java.util.* ;
import java.util.ArrayList;

public class knightTour {
public static void fillArrayList(ArrayList<Integer>a){
    Collections.fill(a,-1);
}
    public static ArrayList<ArrayList<Integer>> knightTour(int n, int m) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	   for(int i=0;i<n;i++){
	       ans.add(i , new ArrayList<>());
	   }
	   for(int i=0;i<n;i++){
	     fillArrayList(ans.get(i));
	   }
	   helper(0,0,ans,0);
	   return ans;
    }
	 public static void helper(int i , int j , ArrayList<ArrayList<Integer>> graph, int count){
	
      if(i<0 || j< 0 || i>=graph.size() || j>= graph.get(0).size() || graph.get(i).get(j)>-1){
	    return ;	  
	  }else if(count == graph.get(0).size() * graph.size()-1){
	  
	    graph.get(i).set(j,count);
	    return ;
	  }
	
	  graph.get(i).set(j,count);
	  helper(i-2,j+1,graph,count+1);
	  helper(i-1,j+2,graph,count+1);
	  helper(i+1,j+2,graph,count+1);
	  helper(i+2,j+1,graph,count+1);
	  helper(i+2,j-1,graph,count+1);
	  helper(i+1,j-2,graph,count+1);
	  helper(i-1,j-2,graph,count+1);
	  helper(i-2,j-1,graph,count+1);
	  
	   graph.get(i).set(j,-1);
   	} 
}

//Mistakes 

// DO read this mistakes 

// Knight’s Tour – Mistakes vs Correct Solution (Chart)
// #	Your Code (Mistake)	Why It’s Wrong	Working Solution (Fix)	Why the Fix Works
// 1	Created rows using new ArrayList<>()	Rows had size = 0	Initialize each row with m values	Knight needs an n × m board
// 2	Used Collections.fill(row, -1)	fill() does not add elements, only replaces existing ones	Use loop to add -1 m times	Ensures valid indexing
// 3	Accessed graph.get(i).get(j)	Causes IndexOutOfBoundsException	Board is fully initialized	Safe cell access
// 4	Base condition checked after invalid return	Valid last move could be rejected	Check success after placing move	Correct termination logic
// 5	Helper method returns void	Solution gets erased by backtracking	Helper returns boolean	Stops recursion when solution found
// 6	Always backtracked (set(i,j,-1))	Even correct path was removed	Backtrack only if path fails	Preserves valid solution
// 7	Hardcoded knight moves	Repetitive and error-prone	Used dx[] and dy[] arrays	Cleaner and safer
// 8	No early stopping	Explores unnecessary paths	Return true when solved	Improves efficiency






//Accurate Code
 /*


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
public static ArrayList<ArrayList<Integer>> knightTour(int n, int m) {

    ArrayList<ArrayList<Integer>> board = new ArrayList<>();

    // initialize board with -1
    for (int i = 0; i < n; i++) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            row.add(-1);
        }
        board.add(row);
    }

    helper(0, 0, board, 0);
    return board;
}

public static boolean helper(int i, int j,
        ArrayList<ArrayList<Integer>> board, int moveCount) {

    // invalid move
    if (i < 0 || j < 0 || i >= board.size()
            || j >= board.get(0).size()
            || board.get(i).get(j) != -1) {
        return false;
    }

    // place move
    board.get(i).set(j, moveCount);

    // success condition
    if (moveCount == board.size() * board.get(0).size() - 1) {
        return true;
    }

    // all 8 knight moves
    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    for (int k = 0; k < 8; k++) {
        if (helper(i + dx[k], j + dy[k], board, moveCount + 1)) {
            return true; // stop once solution is found
        }
    }

    // backtrack
    board.get(i).set(j, -1);
    return false;
}
}


*/
