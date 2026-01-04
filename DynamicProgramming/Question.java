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
