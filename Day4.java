// Problem : Merge Two Sorted Arrays
// You are given two sorted arrays arr1 of size m and arr2 of size n. Your task is to merge these two arrays into a single sorted array without using any extra space (i.e., in-place merging). The elements in arr1 should be merged first, followed by the elements of arr2, resulting in both arrays being sorted after the merge.

// Input :
// Two sorted integer arrays arr1 of size m and arr2 of size n.
// Example : 
// arr1 = [1, 3, 5, 7]
// arr2 = [2, 4, 6, 8]

// Output :
// Both arr1 and arr2 should be sorted after the merge. Since you cannot use extra space, the final result will be reflected in arr1 and arr2.
// Example:
// arr1 = [1, 2, 3, 4]
// arr2 = [5, 6, 7, 8]

import java.util.Arrays;

public class Day4{
  
    public static void mergeArrays(int[] arr1, int[] arr2){
        int l1 = arr1.length;
        int l2 = arr2.length;

        for(int i = 0; i < l1; i++){
            if(arr1[i] > arr2[0]){
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            int first = arr2[0];
            int j = 1;

            while ( j < l2 && arr2[j] < first) {
                arr2[j -1] = arr2[j];
                j++;
            }

            arr2[j - 1] = first;
        }
    }

    public static void main(String[] args){
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};

        mergeArrays(arr1, arr2);

        System.out.println(Arrays.toString(arr1));
        System.err.println(Arrays.toString(arr2));
    }
}