// Sliding window maximum problem

import java.util.*;

public class Day23{

    public static int[] maxSlidingWindow(int[] arr, int k){
        if (arr == null || arr.length == 0) return new int[0];

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() &&  deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args){
         int[] arr = {1, 5, 3, 2, 4, 6};
         int k = 3;
         System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
        }
}