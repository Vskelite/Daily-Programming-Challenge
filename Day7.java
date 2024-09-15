// Problem : Trapping Rain Water
// You are given an array height[] of non-negative integers where each element represents the height of a bar in a histogram-like structure. These bars are placed next to each other, and the width of each bar is 1 unit. When it rains, water gets trapped between the bars if there are taller bars on both the left and right of the shorter bars. The task is to calculate how much water can be trapped between these bars after the rain.

// Input :
// An integer array height[] where each element represents the height of a bar in the histogram.
// Example : 
// height[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

// Output :
// * An integer representing the total units of water that can be trapped between the bars.
// Example
// Output: 6

public class Day7{
    
    public static int trappedWater(int[] arr){
        int leftBar = 0;
        int rightBar = arr.length - 1;
        int leftMax = arr[leftBar], rightMax = arr[rightBar];
        int waterTrapped = 0;

        while (leftBar < rightBar) {
            if ( arr[leftMax] <= arr[rightMax]) {
                leftBar++;
                leftMax = Math.max(leftMax, arr[leftBar]);
                waterTrapped += leftMax - arr[leftBar];
            }else{
                rightBar--;
                rightMax = Math.max(rightMax, arr[rightBar]);
                waterTrapped += rightMax - arr[rightBar];
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Amount of water trapped: "+ trappedWater(height));
    }
}