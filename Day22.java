// Problem : First Element to Repeat k Times
// You are given an array of integers and an integer k. Your task is to find the first element in the array that appears exactly k times. If no such element exists, return -1.

// Input : arr = [3, 1, 4, 4, 5, 2, 6, 1, 4], k = 2

// Output : 1

import java.util.HashMap;

public class Day22 {

    public static int findFirstElement(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 6, 6, 6, 8, 8, 7, 7, 7 };
        int k = 3;
        System.out.println(findFirstElement(arr, k));

    }
}