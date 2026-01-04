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
