package jzOffer;

/**
 * @author zhaohang <zhaohang06@kuaishou.com>
 * Created on 2021-09-17
 */
public class Fibonacci {

    public int rec_Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return rec_Fibonacci(n - 1) + rec_Fibonacci(n - 2);
        }
    }

    public int dp_Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
