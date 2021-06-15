import java.util.*;
import java.io.*;

/// Given 2D array with alphabets
/// Search the given word from the grid
/// travelling across the grid can be done by moving - up, down,left, right.

public class WordSearch{

    static int[] rows = {-1,1,0,0};
    static int[] col = {0,0,-1,1};

    static boolean recurse(char[][] grid, String word, int n, int i, int r, int c){

        if(i >= word.length()) return false;
        if(r<0 || c<0 || r>=n || c >=n) return false;
        if(grid[r][c] != word.charAt(i)) return false;

        /// The word is found.
        if(i==word.length()-1) return true;

        /// Marking visited node
        grid[r][c] = '$';

        /// recursive intuition
        boolean retval = false;

        for(int k=0; k<4; k++){
            retval = recurse(grid, word, n, i+1,r+rows[k], c+col[k]);

            /// retval will hold true when the word is found.
            if(retval) break;

        }

        /// Mark the node as not visited for next iteration as word is not found.
        grid[r][c] = word.charAt(i);
        return retval;
    }

    static boolean find(char[][] grid, String word, int n){

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == word.charAt(0)){
                    if(recurse(grid, word, n, 0, i, j)) return true;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        
        int n,i,j;

        System.out.println("Size of grid: ");
        n = sc.nextInt();

        char[][] chars = new char[n][n];
        for(i=0; i<n; i++){
            for(j=0; j<n; j++) chars[i][j] = sc.next().charAt(0);
        }

        String word = sc.next();

        /// Output true is word is found and false if not found.
        System.out.println(find(chars, word, n));


        sc.close();
    }
}
