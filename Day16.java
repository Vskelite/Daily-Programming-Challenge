// Problem : LCM (Least Common Multiple) of Two Numbers
// You are given two integers, N and M. Your task is to find the Least Common Multiple (LCM) of these two numbers. The LCM of two integers is the smallest positive integer that is divisible by both N and M.

// Input : N = 4, M = 6

// Output : 12

import java.util.Scanner;

public class Day16 {

    public static int findGCD(int num1, int num2) {
        if (num1 == 0)
            return num2;

        if (num2 == 0)
            return num1;

        if (num1 == num2)
            return num1;

        if (num1 > num2) {
            if (num1 % num2 == 0)
                return num2;
            return findGCD(num1 - num2, num2);
        }

        if (num2 > num1)
            if (num2 % num1 == 0) {
                return num1;
            }
        return findGCD(num1, num2 - num1);
    }

    public static int findLCM(int num1, int num2) {
        return (num1 * num2) / findGCD(num1, num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter 2nd number: ");
        int num2 = sc.nextInt();
       
        System.out.print(findLCM(num1, num2));
        sc.close();
    }
}