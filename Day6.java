// Problem : Find All Subarrays with Zero Sum
// You are given an integer array arr of size n. Your task is to find all the subarrays whose elements sum up to zero. A subarray is defined as a contiguous part of the array, and you must return the starting and ending indices of each subarray.

// Input :
// An integer array arr of size n where n represents the number of elements in the array.
// Example : 
// Input: [1, 2, -3, 3, -1, 2]

// Output :
// - Return a list of tuples, where each tuple contains two integers. The starting index (0-based) of the subarray. The ending index (0-based) of the subarray.
// - The output should list all subarrays that sum to zero. If no such subarrays are found, return an empty list.
// Example
// Output: [(0, 2), (1, 3)]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day6 {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();

        HashMap<Integer, ArrayList<Integer>> prefixSumMap = new HashMap<>();

        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
           
            prefixSum += arr[i];

            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

            if (prefixSumMap.containsKey(prefixSum)) {
                ArrayList<Integer> previousIndices = prefixSumMap.get(prefixSum);
                for (int index : previousIndices) {
                    result.add(new int[]{index + 1, i});
                }
            }

            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, new ArrayList<>());
            }
            prefixSumMap.get(prefixSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 1};
        List<int[]> output = findZeroSumSubarrays(arr);

        for (int[] subarray : output) {
            System.out.println("(" + subarray[0] + ", " + subarray[1] + ")");
        }
    }
}
