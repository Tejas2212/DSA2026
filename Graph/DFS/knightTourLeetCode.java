package DSA2026.Graph.DFS;

//here we don't have to explore all paths 
public class knightTourLeetCode {
        public boolean checkValidGrid(int[][] grid) {
         if(grid[0][0]!=0)return false; // check if we have valid a at start or not 
        return helper(0,0,grid,0);
    }
     public boolean  helper(int i , int j , int [][]a, int count){

        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]!=count) return false;  
        else if(a[i][j]==a.length * a.length -1)return true;
       
       boolean temp=false;
       if(temp|| 
       helper(i-2,j+1,a,count+1)||
	   helper(i-1,j+2,a,count+1)||
	   helper(i+1,j+2,a,count+1)||
	   helper(i+2,j+1,a,count+1)||
	   helper(i+2,j-1,a,count+1)||
	   helper(i+1,j-2,a,count+1)||
	   helper(i-1,j-2,a,count+1)||
	   helper(i-2,j-1,a,count+1))return true;
    return false;
    }
}

/*
 * 
 * 
 * | Problem Type             | TC             | SC           | Technique    |
| ------------------------ | -------------- | ------------ | ------------ |
| Knight Tour Construction | **O(8^(n*m))** | O(n*m)       | Backtracking |
| Knight Tour Validation   | **O(n²)**      | O(1) / O(n²) | Simulation   |

 */
