import java.util.*;
import java.io.*;

/// Find the number of islands.
/// An Island is land which is surrounded by water.
/// Land is denoted by 1
/// Water is denoted by 0

public class NumberOfIslands {

    static int N = 10005, M = 10005;
    static int[][] grid = new int[N][M];


    static void dfs( int r, int c){

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length) return;

        // check if adjacent node is water(0)
        if(grid[r][c] == 0) return;

        // Mark the current node as visited.
        grid[r][c] = 0;

        int[] rows = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        //// Check for each neighbouring vertex
        for(int i=0; i<4; i++){
            dfs(r+rows[i], c+col[i]);
        }
    }

    static int numOfIslands(){
        int result = 0;   /// To calculate number of islands

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j] == 1){
                    dfs(i, j);
                    
					/// Increment the number of islands after each dfs is complete.
                    result++;   
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = scan.nextInt();
            }
        }

        System.out.println(numOfIslands());

        scan.close();
    }
}
