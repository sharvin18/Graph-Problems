import java.util.*;
import java.io.*;

// You are given nodes starting from 1 to A
// Find if a path exists between Nodes 1 and A.
// Start your search from the node 1.
// Return 1 if path exists, else return 0.

public class pathInDirectedGraph {

    static ArrayList<Integer> visited;

    static public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        visited = new ArrayList<>();

        while(!qu.isEmpty()){

            int num = qu.remove();
            if(visited.contains(num)) continue;
            if(num == A) return 1;

            visited.add(num);
            ArrayList<Integer> nodes = B.get(num-1);
            if(nodes.isEmpty()) continue;
            for(int k: nodes){
                qu.add(k);
            }
        }

        return 0;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int t, n;

        System.out.println("Enter number of nodes: ");
        t = Integer.parseInt(infile.readLine());
        for(int i=0; i<t; i++){
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter number of edges: ");
        n = Integer.parseInt(infile.readLine());
        for(int j=0; j<n; j++) {
            String[] inp = infile.readLine().split(" ");
            graph.get(Integer.parseInt(inp[0])-1).add(Integer.parseInt(inp[1]));
        }
        
        //System.out.println(graph);

        System.out.println(solve(t, graph));

        infile.close();
    }
}
