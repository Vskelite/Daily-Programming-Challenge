// Problem: Find the missing number
// You are given an array arr containing n-1 distinct integers. The array consists of integers taken from the range 1 to n, meaning one integer is missing from this sequence. Your task is to find the missing integer.

// Input :
// An integer array arr of size n-1 where the elements are distinct and taken from the range 1 to n.
// Example : arr = [1, 2, 4, 5]

// Output :
// Return the missing integer from the array.
// Example: Missing Number : 3

public class Day2{

     public static int missingNum(int[] arr, int N){
            int check = ((N + 1)*(N + 2))/2;
            for(int i = 0; i<arr.length; i++){
                check -= arr[i];
            }
            return check;
        }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,8};
        int N = arr.length;
        System.out.println(missingNum(arr,N));
    }
}