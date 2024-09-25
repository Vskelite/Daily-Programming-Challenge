// Problem : Prime Factorization of a Number
// Given a positive integer N, your task is to find its prime factorization. Return a list of prime numbers that multiply together to give N. If N is prime, the output should be a list containing only N.

// Input : N = 18

// Output : [2, 3, 3]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day17{
    
    public static List<Integer> findPrimeFactors(int num){
          List<Integer> factors = new ArrayList<>();

          while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
          }

          for(int i = 3; i * i <= num; i+=2){
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
          }

          if( num > 2){
            factors.add(num);
          }
          return factors;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num =  sc.nextInt();
        sc.close();
        System.out.println("Prime factors are: "+ findPrimeFactors(num));
    }
}