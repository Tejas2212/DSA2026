package DSA2026.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    /*
     * Edge represents a weighted connection from current vertex to destination vertex
     */
    public static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    /*
     * Pair is used to store a path and its total weight
     */
    public static class PathPair {
        String path;
        int weight;

        PathPair(String path, int weight) {
            this.path = path;
            this.weight = weight;
        }
    }

    /*
     * Comparator for PriorityQueue
     * This creates a MIN heap based on path weight
     */
    public static class MinHeapComparator implements Comparator<PathPair> {
        @Override
        public int compare(PathPair p1, PathPair p2) {
            // Using Integer.compare to avoid overflow
            return Integer.compare(p1.weight, p2.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter graph input");
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(src).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(src, weight));
        }

        System.out.println(hasPath(0, 6, new boolean[vertices], graph));
        printAllPaths(0, 6, new boolean[vertices], graph, "0");
        analyzeAllPaths(0, 6, new boolean[vertices], graph, "0", 0);
    }

    /*
     * Checks if any path exists between source and destination
     */
    public static boolean hasPath(
            int src,
            int dest,
            boolean[] visited,
            ArrayList<ArrayList<Edge>> graph) {

        if (src == dest) return true;

        visited[src] = true;

        for (Edge edge : graph.get(src)) {
            if (!visited[edge.dest]) {
                if (hasPath(edge.dest, dest, visited, graph)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Prints all possible paths from source to destination
     */
    public static void printAllPaths(
            int src,
            int dest,
            boolean[] visited,
            ArrayList<ArrayList<Edge>> graph,
            String pathSoFar) {

        if (src == dest) {
            System.out.println(pathSoFar);
            return;
        }

        visited[src] = true;

        for (Edge edge : graph.get(src)) {
            if (!visited[edge.dest]) {
                printAllPaths(
                        edge.dest,
                        dest,
                        visited,
                        graph,
                        pathSoFar + " " + edge.dest
                );
            }
        }

        visited[src] = false;
    }

    // ---------- Global results ----------
    static String smallestPath = "";
    static int smallestWeight = Integer.MAX_VALUE;

    static String largestPath = "";
    static int largestWeight = Integer.MIN_VALUE;

    static int criteria = 40;

    // Ceil: smallest path weight greater than criteria
    static String ceilPath = "";
    static int ceilWeight = Integer.MAX_VALUE;

    // Floor: largest path weight smaller than criteria
    static String floorPath = "";
    static int floorWeight = Integer.MIN_VALUE;

    static int k = 3;

    /*
     * Min heap to store top K largest paths
     */
    static PriorityQueue<PathPair> minHeap =
            new PriorityQueue<>(new MinHeapComparator());

    /*
     * This function evaluates:
     * 1. Smallest path
     * 2. Largest path
     * 3. Ceil path (just above criteria)
     * 4. Floor path (just below criteria)
     * 5. Kth largest path using a min heap
     *
     * We use multiple if conditions instead of if-else
     * because more than one condition can be true at the same time
     */
    public static void analyzeAllPaths(
            int src,
            int dest,
            boolean[] visited,
            ArrayList<ArrayList<Edge>> graph,
            String pathSoFar,
            int weightSoFar) {

        if (src == dest) {

            // Largest path
            if (weightSoFar > largestWeight) {
                largestWeight = weightSoFar;
                largestPath = pathSoFar;
            }

            // Smallest path
            if (weightSoFar < smallestWeight) {
                smallestWeight = weightSoFar;
                smallestPath = pathSoFar;
            }

            // Ceil path: smallest weight greater than criteria
            if (weightSoFar > criteria && weightSoFar < ceilWeight) {
                ceilWeight = weightSoFar;
                ceilPath = pathSoFar;
            }

            // Floor path: largest weight smaller than criteria
            if (weightSoFar < criteria && weightSoFar > floorWeight) {
                floorWeight = weightSoFar;
                floorPath = pathSoFar;
            }

            // Kth largest path using min heap
            if (minHeap.size() < k) {
                minHeap.add(new PathPair(pathSoFar, weightSoFar));
            } else if (weightSoFar > minHeap.peek().weight) {
                minHeap.poll();
                minHeap.add(new PathPair(pathSoFar, weightSoFar));
            }

            return;
        }

        visited[src] = true;

        for (Edge edge : graph.get(src)) {
            if (!visited[edge.dest]) {
                analyzeAllPaths(
                        edge.dest,
                        dest,
                        visited,
                        graph,
                        pathSoFar + " " + edge.dest,
                        weightSoFar + edge.weight
                );
            }
        }

        visited[src] = false;
    }
}
