package DSA2026.Graph.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

//checkout last one 3rd solution
/* 
class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    public void solve(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O')
                q.add(new Pair(0, i));
        }
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O')
                q.add(new Pair(i, 0));

        }
        for (int i = 0; i < n; i++) {
            if (a[i][m - 1] == 'O')
                q.add(new Pair(i, m - 1));

        }
        for (int i = 0; i < m; i++) {
            if (a[n - 1][i] == 'O')
                q.add(new Pair(n - 1, i));

        }
        while (q.size() != 0) {
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            if (vis[i][j])
                continue;
            vis[i][j] = true;
            if (i > 0 && a[i - 1][j] == 'O' && vis[i - 1][j] == false) {
                q.add(new Pair(i - 1, j));
            }
            if (j > 0 && a[i][j - 1] == 'O' && vis[i][j - 1] == false) {
                q.add(new Pair(i, j - 1));
            }
            if (i < n - 1 && a[i + 1][j] == 'O' && vis[i + 1][j] == false) {
                q.add(new Pair(i + 1, j));
            }
            if (j < m - 1 && a[i][j + 1] == 'O' && vis[i][j + 1] == false) {
                q.add(new Pair(i, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O' && vis[i][j] == false) {
                    a[i][j] = 'X';
                }
            }
        }
    }
}*/

/*
 * Another solution without visited array
 * 
 */

/* 
 class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    public void solve(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O')
                q.add(new Pair(0, i));
        }
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O')
                q.add(new Pair(i, 0));

        }
        for (int i = 0; i < n; i++) {
            if (a[i][m - 1] == 'O')
                q.add(new Pair(i, m - 1));

        }
        for (int i = 0; i < m; i++) {
            if (a[n - 1][i] == 'O')
                q.add(new Pair(n - 1, i));
        }
        while (q.size() != 0) {
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            if (a[i][j] == 'x')
                continue;
            a[i][j] = 'x';
            if (i > 0 && a[i - 1][j] == 'O') {
                q.add(new Pair(i - 1, j));
            }
            if (j > 0 && a[i][j - 1] == 'O') {
                q.add(new Pair(i, j - 1));
            }
            if (i < n - 1 && a[i + 1][j] == 'O') {
                q.add(new Pair(i + 1, j));
            }
            if (j < m - 1 && a[i][j + 1] == 'O') {
                q.add(new Pair(i, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'x') {
                    a[i][j] = 'O';
                }
            }
        }
    }
}*/
/*
 * In 01 matrix and this problem we have to think exactly opposite way
 * what ask what we are doing like althou we have ask 'O' suurounded by x but we
 * are finding 'O' not surrounded by x this can be achive by finding or border
 * 'O'
 * 
 * soemwhat same we have done in 01 matrix
 */

/*
 * More clean and optmial avoid traversing border again
 * IMp
 */

class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    public void solve(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O')
                q.add(new Pair(i, 0));
        }
        for (int j = 1; j < m; j++) {
            if (a[0][j] == 'O')
                q.add(new Pair(0, j));
        }
        for (int i = 1; i < n; i++) {
            if (a[i][m - 1] == 'O')
                q.add(new Pair(i, m - 1));
        }
        for (int j = 1; j < m - 1; j++) {
            if (a[n - 1][j] == 'O')
                q.add(new Pair(n - 1, j));
        }
        while (q.size() != 0) {
            Pair rem = q.remove();
            int i = rem.i;
            int j = rem.j;
            if (a[i][j] == '#')
                continue;
            a[i][j] = '#';
            if (i > 0 && a[i - 1][j] == 'O') {
                q.add(new Pair(i - 1, j));
            }
            if (j > 0 && a[i][j - 1] == 'O') {
                q.add(new Pair(i, j - 1));
            }
            if (i < n - 1 && a[i + 1][j] == 'O') {
                q.add(new Pair(i + 1, j));
            }
            if (j < m - 1 && a[i][j + 1] == 'O') {
                q.add(new Pair(i, j + 1));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == '#') {
                    a[i][j] = 'O';
                }
            }
        }
    }
}
