// Problem : Find the Leaders in an Array
// You are given an integer array arr of size n. An element is considered a leader if it is greater than all the elements to its right. Your task is to find all such leader elements in the array.

// Input :
// An integer array arr of size n.
// Example : 
// arr = [16, 17, 4, 3, 5, 2]

// Output :
// Return an array containing all the leader elements in the order in which they appear in the original array.
// Example:
// Leaders: [17, 5, 2]

public class Day5{

    public static int[] findLeaders(int[] arr){
        int n = arr.length;
        int[] tempLeaders = new int[n];
        int index = 0;

        int maxRight = arr[n - 1];
        tempLeaders[index++] = maxRight;

        for(int i = n-2; i>= 0; i--){
            if(arr[i] > maxRight){
                tempLeaders[index++] = arr[i];
                maxRight = arr[i];
            }
        }

        int[] leaders = new int[index];
        for(int i = 0; i < index; i++){
            leaders[i] = tempLeaders[index - i - 1];
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 40, 3, 5, 2};
        int[] leaders = findLeaders(arr);
        System.out.println("Leaders: ");
        for(int leader: leaders){
            System.out.print(leader +" ");
        }
    }
}