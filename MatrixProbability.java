package com.learning.Graphs;

import java.io.*;

// Given a rectangular matrix, we can move from current cell in 4 directions
// with equal probability. The 4 directions are right, left, top or bottom.
// Calculate the Probability that after N moves from a given position
// (i, j) in the matrix, we will not cross boundaries of the matrix at any point.


// Probability of one move can be calculated with the help of number of directions available
// As we have 4 directions, each directions will contribute equally, hence
// probability of one move will be 1/4 === 0.25

public class MatrixProbability {

    // Direction array that defines the movement in up, down, left, right dir respectively
    static int[] xDir = {-1, 1, 0, 0};
    static int[] yDir = {0, 0, -1, 1};

    static double findProb(int n, int m, int currX, int currY, int totSteps){

        // return 0 if this move goes out of the matrix
        if(currX <= 0 || currY <= 0 || currX > n || currY > m) return 0;

        // return 1 if total steps are fulfilled
        if(totSteps == 0) return 1;

        double probability = 0.0;

        for(int i=0; i<4; i++){

            // Sending 4 calls, 1 in each directions.
            probability += (findProb(n, m, currX+xDir[i], currY+yDir[i], totSteps-1)*0.25);
        }

        return probability;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));

        // Input n,m that implies n x m matrix
        int n = Integer.parseInt(infile.readLine());
        int m = Integer.parseInt(infile.readLine());
        int steps = Integer.parseInt(infile.readLine());

        System.out.println("Probability: " + findProb(n, m, 2, 2, steps));

        infile.close();
    }
}
