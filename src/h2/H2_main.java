package h2;

public class H2_main {
    public static int[] arr = new int[1000];

    public static void main (String[] args) {
        int n = 40;
        benchmark(n);
    }

    public static void benchmark(int n) {
        long startTime, endTime;

        startTime = System.nanoTime();
        int result1 = fibonacci(n);
        endTime = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + result1 + " computed in " + (endTime - startTime) + " ns using plain recursion.");

        startTime = System.nanoTime();
        int result2 = fibonacciCached(n);
        endTime = System.nanoTime();
        System.out.println("FibonacciCached(" + n + ") = " + result2 + " computed in " + (endTime - startTime) + " ns using memoization.");

        startTime = System.nanoTime();
        int result3 = fibonacci_for_loop(n);
        endTime = System.nanoTime();
        System.out.println("FibonacciForLoop(" + n + ") = " + result3 + " computed in " + (endTime - startTime) + " ns using iterative approach.");
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciCached(int n) {
        if (n <= 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        return arr[n];
    }

    public static int fibonacci_for_loop(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
