import java.math.BigInteger;
import java.util.Scanner;

public class Day29 {

    public static BigInteger fibonacci(int n) {
    
        BigInteger[] fib = new BigInteger[n + 1];

        if (n == 0) {
            return BigInteger.ZERO;
        }
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }
}
