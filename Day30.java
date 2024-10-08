import java.util.Arrays;

public class Day30{
    
    public static int coinChange(int[] coins , int amount){
           int[] dp = new int[amount + 1];
           Arrays.fill(dp, amount + 1);

           dp[0] = 0;

           for(int i = 1; i <= amount; i++){
             for(int coin: coins){
                if( i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] +1);
                }
             }
           }
           return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,7};
        int amount = 11;
        System.out.println(coinChange(arr, amount));
    }
}