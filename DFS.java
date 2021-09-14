import java.util.*;
import java.io.*;

public class DFS {

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

    static void DFS(int v, boolean visited[], Graph graph){
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recurse for all the vertices adjacent to this vertex
        Iterator<Integer> i = graph.list.get(v).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited, graph);
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
        boolean visited[] = new boolean[nodes];

        // Starting from node 2
        DFS(2, visited, graph);
    }
}
