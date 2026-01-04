package DynamicProgramming;

public class Question {
    
}
// fibonacci number
class Solution {
    int[] arr;

    public int fib(int n) {
        arr = new int[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = helper(n - 1) + helper(n - 2);
        return arr[n];
    }
}
// tabulation
class Solution {
    int[] arr;

    public int fib(int n) {
        if (n <= 1) return n;

        arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        return helper(n);
    }

    private int helper(int n) {
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
