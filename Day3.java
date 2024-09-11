// Problem: Find the duplicate number
// You are given an array arr containing n+1 integers, where each integer is in the range [1, n] inclusive. There is exactly one duplicate number in the array, but it may appear more than once. Your task is to find the duplicate number without modifying the array and using constant extra space.
// Input :
// An integer array arr of size n+1, where each element is an integer in the range [1, n].
// Example : arr = [3, 1, 3, 4, 2]

// Output :
// Return the duplicate integer present in the array.
// Example: Duplicate Number : 3

public class Day3{
    
    public static int findDuplicateNum(int[] arr) {
        int start = 1;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            
            for (int num : arr) {
                if (num <= mid) {
                    count++;
                }
            }
            
            if (count > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println("Duplicate Number: " + findDuplicateNum(arr)); 
    }
}
