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
// the optimized space sol
class Solution {

    public int fib(int n) {
    if (n <= 1) return n;
       int prev=1;
       int prev2=0;
    for(int i=2;i<=n;i++){
    int curr=prev+prev2;
    prev2=prev;
    prev=curr;
}
return prev;
        
    }
}
// house robber
class Solution {
    int dp[];
    public int rob(int[] arr) {
        dp=new int[arr.length+1];
        return helper(arr, arr.length - 1,dp);
    }

    private int helper(int[] arr, int n,int dp[]) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if(dp[n]!=0){return dp[n];}
        int pick = arr[n] + helper(arr, n - 2,dp);
        int notPick = helper(arr, n - 1,dp);
        return dp[n]=Math.max(pick, notPick);
    }
}
class Solution {

    public int rob(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        int[] arr1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = arr[i];
        }
        int[] arr2 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            arr2[i - 1] = arr[i];
        }

        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];

        int case1 = helper(arr1, arr1.length - 1, dp1);
        int case2 = helper(arr2, arr2.length - 1, dp2);

        return Math.max(case1, case2);
    }

    private int helper(int[] arr, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if (dp[n] != 0) return dp[n];

        int pick = arr[n] + helper(arr, n - 2, dp);
        int notPick = helper(arr, n - 1, dp);

        return dp[n] = Math.max(pick, notPick);
    }
}
// Ninja Training
import java.util.Arrays;

class Solution {
    int dp[][];

    public int helper(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int curr = points[day][i] + helper(day - 1, i, points);
                max = Math.max(max, curr);
            }
        }

        return dp[day][last] = max;
    }

    public int ninjaTraining(int[][] points) {
        int n = points.length;
        dp = new int[n][4];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, 3, points);
    }
}
