import java.util.*;
import java.io.*;

// Find the root vertex of the given graph

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

public class RootVertex {

    static ArrayList<Integer> visited;

    // Dfs to all the nodes to check if all the nodes exists in the current path
    public static void dfs(Graph graph, int currNode){

        if(visited.contains(currNode)) return;

        visited.add(currNode);

        for(int child: graph.list.get(currNode)){
            dfs(graph, child);
        }

        
    }

    // Helper function to initiate the dfs
    public static int findRoot(Graph graph, int nodes){

        for(int currRoot=0; currRoot<nodes; currRoot++){
            visited = new ArrayList<>();
            dfs(graph, currRoot);

            // check if all the nodes are visited in the current iteration
            // if all are visited then current node is the root node
            if(visited.size() == nodes) return currRoot;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int nodes,root,edges;
        ArrayList<Edge> edgeList = new ArrayList<>();

        System.out.println("Enter number of nodes");
        nodes = scan.nextInt();

        System.out.println("Enter number of edges");
        edges = scan.nextInt();

        for(int i=0; i<edges; i++){
            edgeList.add(new Edge(scan.nextInt(), scan.nextInt()));
        }
        scan.close();

        Graph graph = new Graph(edgeList, nodes);

        root = findRoot(graph, nodes);

        if(root == -1) System.out.println("Root vertex does not exists");
        else System.out.println("Root Vertex: " + root);

    }
}

/*
Enter number of nodes
6
Enter number of edges
7
0 1
1 2
2 3
3 0
4 3
4 5
5 0
Root Vertex: 4
*/

