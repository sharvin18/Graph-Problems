import java.util.*;
import java.io.*;

public class dfs {

    // Class for defining the edges
    static class Edge{
        int src,dest;

        public Edge(int source, int dest){
            this.src = source;
            this.dest = dest;
        }
    }

    // Class for initializing the graph
    static class Graph{

        List<List<Integer>> list;

        public Graph(List<Edge> edges, int size){

            list = new ArrayList<>();
            for(int i=0;i<size; i++){
                list.add(new ArrayList<>());
            }

            for(Edge e: edges){
                list.get(e.src).add(e.dest);
            }
        }
    }

    static void BFS(int s, Graph graph, int nodes){
        
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[nodes];
 
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s-1]=true;
        queue.add(s);
 
        while (!queue.isEmpty()){

            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = graph.list.get(s).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n-1])
                {
                    visited[n-1] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        int nodes = 4;
        ArrayList<Edge> edges = new ArrayList<Edge>(){
            {
                add(new Edge(0,1)); add(new Edge(0, 2));
                add(new Edge(1, 2)); add(new Edge(2,0));
                add(new Edge(2,3)); add(new Edge(3,3));
            }
        };

        Graph graph = new Graph(edges, nodes);

        // Starting from node 2
        DFS(2, graph, nodes);
    }
}
