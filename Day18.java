// Problem : Count the Number of Divisors of a Number
// Given a positive integer N, your task is to find the total number of divisors (factors) of N. A divisor of N is any integer that divides N without leaving a remainder.

// Input : N = 12

// Output : 6

import java.util.Scanner;

public class Day18{

    public static int findTotalDivisors(int num){
         int count = 0;
        for(int i = 1; i * i< num; i++){

            if( num % i == 0){
                count++;
                if( i != num / i){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        sc.close();
        System.err.println(findTotalDivisors(num));
    }
}
