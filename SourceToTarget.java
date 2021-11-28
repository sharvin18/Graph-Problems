import java.util.*;
import java.io.*;

/*

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

*/

class SourceToTarget {
    
    static List<List<Integer>> result;
    static int n;
    
    static void getPaths(List<List<Integer>> graph, int currNode, List<Integer> path){
        
        if(currNode == n-1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        List<Integer> tempPath;
        
        for(int k: graph.get(currNode)){
            tempPath = new ArrayList<>(path);
            tempPath.add(k);
            getPaths(graph, k, tempPath);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
	
		BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> graph = new ArrayList<>();
		List<Integer> temp;
		result = new ArrayList<>();
		int i,j;
		
		n = Integer.parseInt(infile.readLine());
		
		for(i=0; i<n; i++){
			String[] inp = infile.readLine().split(" ");
			temp = new ArrayList<>();
			for(String k: inp){
				temp.add(Integer.parseInt(k));
			}
			graph.add(new ArrayList<>(temp));
		}
		
		temp = new ArrayList<>();
        temp.add(0);
        getPaths(graph, 0, temp);
        
        System.out.println(result);
		infile.close();
	}
}

