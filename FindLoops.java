import java.util.*;
import java.io.*;

/// Find if a graph contains any Cycles/Loops.

public class FindLoops {

    static int N=10005;
    static int[][] graph = new int[N][N];	

    /// A Hashmap Keep track of parent and child vertex in current iteration
    static HashMap<Integer, Integer> track = new HashMap<>();

    static boolean dfs(int parent, int child, int size){

        /// If hashmap contains a parent that is the child node in the current iteration
        /// then the graph contains a cycle.
        if(track.containsKey(child)) return true;

        track.put(parent, child);

        boolean check = false;

        for(int i=0; i<size; i++){
            if(graph[child][i] == 0) continue;

            check = dfs(child, i, size);         /// Child becomes the parent for next iteration
        }

        return check;
    }

    static boolean hasLoops(int[][] graph, int size){

        boolean flag = false;
        track.clear();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if (graph[i][j] != 0){

                    flag = dfs(i, j, size);
                    track.clear();      /// Clear the hashmap after every iteration

                }
                if(flag) break;
            }
        }

        return flag;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        int i,j,n;

        n = Integer.parseInt(infile.readLine());
        for(i=0; i<n; i++){
            String[] inp = infile.readLine().split(" ");
            for(j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(inp[j]);
            }
        }

        System.out.println(hasLoops(graph, n));

        infile.close();
    }
}
