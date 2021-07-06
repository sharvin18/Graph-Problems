import java.util.*;
import java.io.*;

// Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m].
// A number is called stepping number if all adjacent digits have an
// absolute difference of 1. 321 is a Stepping Number while 421 is not.

// Brute force approach iterates through all the numbers between n and m.
// This graph aproach uses BFS and uses the last digit of the numbers and
// checks if the next number or previous number is a Stepping number or not.

public class SteppingNumbers {

    // To store the result
    static StringBuilder result = new StringBuilder();

    static void bfs(int n, int m, int number){

        // Queue is used to store the possible numbers
        Queue<Integer> stepNums = new LinkedList<>();

        stepNums.add(number);

        while(!stepNums.isEmpty()){

            int currentNum = stepNums.poll();

            if(currentNum >= n && currentNum <= m){
                result.append(currentNum + " ");
            }

            if(currentNum == 0 || currentNum > m) continue;

            // Gets the last digit of the current Stepping number
            // to find the next stepping numbers
            int lastDigit = currentNum%10;

            // Find the next numbers
            int num1 = currentNum*10 + (lastDigit-1);
            int num2 = currentNum*10 + (lastDigit+1);

            // If lastDigit is 0 then only possible
            // digit after 0 can be 1 for a Stepping Number
            if(lastDigit == 0) stepNums.add(num2);

            // If lastDigit is 9 then only possible
            // digit after 9 can be 8 for a Stepping Number
            else if(lastDigit == 9) stepNums.add(num1);

            // Else both are stepping numbers
            else{
                stepNums.add(num1);
                stepNums.add(num2);
            }
        }

    }

    static void stepNumbers(int n, int m){
        for(int i=0; i<=9; i++)
            bfs(n,m,i);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(infile.readLine());
        m = Integer.parseInt(infile.readLine());

        stepNumbers(n,m);

        System.out.println(result);

        infile.close();
    }
}
