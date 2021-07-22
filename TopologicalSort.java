import java.util.*;
import java.io.*;

// Implement Topological Sorting

// Setting up the edges
class Edge{
    int src,dest;

    public Edge(int source, int dest){
        this.src = source;
        this.dest = dest;
    }
}

// Class for initializing the graph
class Graph{

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

public class TopologicalSort {

    static ArrayList<Integer> visited;
    static Stack<Integer> result;

    static void dfs(Graph graph, int currNode){

        if(visited.contains(currNode)) return;

        visited.add(currNode);

        for(int vertex: graph.list.get(currNode)){
            dfs(graph, currNode);
        }

        result.push(currNode);
    }

    static void topoSort(Graph graph, int nodeCount){

        visited = new ArrayList<>();
        result = new Stack<>();

        for(int i=0; i<nodeCount; i++){
            if(!visited.contains(i)){
                dfs(graph, i);
            }
        }

        while(!result.isEmpty()){
            System.out.println(result.pop() + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        ArrayList<Edge> edge = new ArrayList<>();
        System.out.println("Enter number of nodes: ");
        int nodes = scan.nextInt();

        System.out.println("Enter number of edges: ");
        int edges = scan.nextInt();

        for(int i=0; i<edges; i++){
            edge.add(new Edge(scan.nextInt(), scan.nextInt()));
        }

        Graph graph = new Graph(edge, nodes);

        topoSort(graph, nodes);

        scan.close();
    }
}
