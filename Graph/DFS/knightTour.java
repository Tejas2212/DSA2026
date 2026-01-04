package DSA2026.Graph.DFS;

 
import java.util.ArrayList;


public class knightTour {
public static ArrayList<ArrayList<Integer>> knightTour(int n, int m) {

    ArrayList<ArrayList<Integer>> a = new ArrayList<>();

    // initialize a with -1
    for (int i = 0; i < n; i++) {
        ArrayList<Integer> row = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            //Collections.fill() will work only on exsting element 
            //like array whwre we have default values arraylist is empty 
            //do we are doing this mnaually 
            row.add(-1);
        }
        a.add(row);
    }

    helper(0, 0, a, 0);
    return a;
}

public static boolean helper(int i, int j,
        ArrayList<ArrayList<Integer>> a, int count) {

    // invalid move
    if (i < 0 || j < 0 || i >= a.size()
            || j >= a.get(0).size()
            || a.get(i).get(j) != -1) {
        return false;
    }

            // place move
    a.get(i).set(j, count);

    // success condition
    if (count == a.size() * a.get(0).size() - 1) {
        return true;
    }



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

    // backtrack
    a.get(i).set(j, -1);
    return false;
}
}
