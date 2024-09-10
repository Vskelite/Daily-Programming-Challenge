

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