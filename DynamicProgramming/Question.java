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
// unique paths-leetcode 62
class Solution {
    int dp[][];
    public int helper(int m,int n){
      if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }if(dp[m][n]!=0){
            return dp[m][n];
        }
        int up=helper(m-1,n);
        int left=helper(m,n-1);
        return dp[m][n]=up+left;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        return helper(m-1,n-1);
    }
}
// unique paths 2-leetcode 63
class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m-1,n-1,grid,dp);
    }
    public int helper(int m,int n,int[][] grid,int dp[][]){
        if(m<0 || n<0){
            return 0;
        }
        if(grid[m][n]==1){
            return 0;
        }
        if(m==0 && n==0){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int up=helper(m-1,n,grid,dp);
        int left=helper(m,n-1,grid,dp);
        return dp[m][n]=up+left;
    }
}
//min path sum-leetcode 64
class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        return helper(grid.length - 1, grid[0].length - 1, grid,dp);
    }

    public int helper(int m, int n, int[][] grid,int dp[][]) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        int up = helper(m - 1, n, grid,dp);
        int left = helper(m, n - 1, grid,dp);

        int minPrev = Math.min(up, left);
        if (minPrev == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return dp[m][n]=grid[m][n] + minPrev;
    }
    
}
// traingle sum-leetcode 120
import java.util.*;

class Solution {
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return helper(0, 0, triangle);
    }

    public int helper(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = helper(i + 1, j, triangle);
        int diag = helper(i + 1, j + 1, triangle);

        return dp[i][j] =
                triangle.get(i).get(j) + Math.min(down, diag);
    }
}

//minimum falling path sum 931
class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int output=Integer.MAX_VALUE;
        dp=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int j=0;j<matrix.length;j++){
            output=Math.min(output,helper(matrix.length-1,j,matrix,dp));
        }
        return output;
    }
    public int helper(int i,int j,int arr[][],int dp[][]){
        if(j>=arr[0].length || j<0){
            return 10000000;
        }
        if(i==0){
            return arr[0][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int u=arr[i][j]+helper(i-1,j,arr,dp);
        int dl=arr[i][j]+helper(i-1,j-1,arr,dp);
        int dr=arr[i][j]+helper(i-1,j+1,arr,dp);
        return dp[i][j]=Math.min(u,Math.min(dl,dr));
    }
}
// ninja and his friends
import java.util.*;

class Solution {
    int[][][] dp;
    int r, c;

    public int cherryPickup(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        dp = new int[r][c][c];

        for (int i = 0; i < r; i++) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return helper(0, 0, c - 1, grid);
    }

    public int helper(int i, int j1, int j2, int[][] grid) {

        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) {
            return (int) -1e9;
        }
        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int max = (int) -1e9;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int value;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += helper(i + 1, j1 + d1, j2 + d2, grid);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
// cherry pickup 2-leetcode 1463
class Solution {
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        dp = new int[r][c][c];

        for (int i = 0; i < r; i++) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    dp[i][j1][j2] = Integer.MIN_VALUE;
                }
            }
        }

        return helper(0, 0, c - 1, grid);
    }

    public int helper(int i, int j1, int j2, int[][] arr) {

        if (j1 < 0 || j1 >= arr[0].length || j2 < 0 || j2 >= arr[0].length) {
            return (int) -1e9;
        }

        if (i == arr.length - 1) {
            if (j1 == j2) return arr[i][j1];
            else return arr[i][j1] + arr[i][j2];
        }

        if (dp[i][j1][j2] != Integer.MIN_VALUE) {
            return dp[i][j1][j2];
        }

        int max = (int) -1e9;

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

                int value;
                if (j1 == j2)
                    value = arr[i][j1];
                else
                    value = arr[i][j1] + arr[i][j2];

                value += helper(i + 1, j1 + di, j2 + dj, arr);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}
// cherry pickup 1-leetcode 741
class Solution {
    int n;
    int[][][] dp;
    static final int NEG = (int) -1e9;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        int ans = helper(0, 0, 0, grid);
        return Math.max(0, ans); 
    }
    public int helper(int r1, int c1, int r2, int[][] grid) {
        int c2 = r1 + c1 - r2;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return NEG;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != Integer.MIN_VALUE) {
            return dp[r1][c1][r2];
        }

        int cherries;
        if (r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }

        int bestNext = Math.max(
                Math.max(helper(r1 + 1, c1, r2 + 1, grid),
                         helper(r1, c1 + 1, r2, grid)),
                Math.max(helper(r1 + 1, c1, r2, grid),
                         helper(r1, c1 + 1, r2 + 1, grid))
        );

        cherries += bestNext;
        dp[r1][c1][r2] = cherries;
        return cherries;
    }
}
// subset sum 
class Solution {
    Boolean dp[][];

    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        dp = new Boolean[n][target + 1];
        return helper(n - 1, target, arr);
    }

    public boolean helper(int index, int target, int[] arr) {

        if (target == 0) return true;

        if (index == 0) {
            return target == arr[0];
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean notTake = helper(index - 1, target, arr);
        boolean take = false;

        if (target >= arr[index]) {
            take = helper(index - 1, target - arr[index], arr);
        }

        return dp[index][target] = notTake || take;
    }
}
// partition sum equal subset-leetcode 416
class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        dp=new Boolean[nums.length][sum+1];
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
       return helper(nums.length-1,target,nums);
    }
    public boolean helper(int index,int target,int arr[]){
        if(target==0){
            return true;
        }
        if(index==0){
            return arr[0]==target;
        }
        if(dp[index][target]!=null){
            return dp[index][target];
        }
        boolean nottake=helper(index-1,target,arr);
        boolean take=false;
        if(target>=arr[index]){
            take=helper(index-1,target-arr[index],arr);
        } return dp[index][target]=take || nottake;
    }
}
// count subset with  sum k
class Solution {
    public int perfectSum(int[] arr, int K) {
       return find(arr.length-1,K,arr);
    }
    public int find(int index,int k,int arr[]){
        if(k==0){
            return 1;
        }
        if(index==0){
            if(k==arr[0]){
                return 1;
            }else{
                return 0;
            }
        }
        int notpick=find(index-1,k,arr);
        int pick=0;
        if(arr[index]<=k){
            pick=find(index-1,k-arr[index],arr);
        }
        return pick+notpick;
    }
}
// 0/1 knapsack
class Solution {
    int dp[][];
    public int knapsack(int W, int val[], int wt[]) {
        dp=new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        return helper(val.length-1,W,val,wt);
        
    }
    public int helper(int index,int weight,int val[],int wt[]){
        if(weight==0){
            return 0;
        }
        if(index==0){
            if(weight>=wt[0]){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[index][weight]!=-1){
            return dp[index][weight];
        }
        
        int notpick=helper(index-1,weight,val,wt);
        int pick=Integer.MIN_VALUE;
        if(weight>=wt[index]){
            pick=val[index]+helper(index-1,weight-wt[index],val,wt);
        }
        return dp[index][weight]=Math.max(pick,notpick);
    }
}
// minimum coins leetcode-322
class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length+1][amount+1];
        int ans= helper(coins.length-1,amount,coins);
        if(ans==(int)1e9){
            return -1;
        }else{
            return ans;
        }
    }
    public int helper(int index,int target,int arr[]){
        if(index==0){
              if(target%arr[index]==0){
                return (target/arr[index]);
              }else{
                return (int)1e9;
              }
        }
        if(dp[index][target]!=0){
            return dp[index][target];
        }
        int nottake=0+helper(index-1,target,arr);
        int take=(int)1e9;
        if(arr[index]<=target){
            take=1+helper(index,target-arr[index],arr);
        }
        return dp[index][target]=Math.min(take,nottake);
    }
}
// target sum -leetcode 494
class Solution {
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        dp=new int[nums.length][2*sum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<2*sum+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(nums.length-1,target,nums,sum);
    }
    public int helper(int index,int target,int arr[],int sum){
        if (Math.abs(target) > sum) return 0;
     if(index==0){
            int count=0;
            if(target==arr[0]){count++;}
            if(target== -arr[0]){count++;}
     return count;}
     if(dp[index][target+sum]!=-1){
        return dp[index][target+sum];
     }
     int plus=helper(index-1,target-arr[index],arr,sum);
     int minus=helper(index-1,target+arr[index],arr,sum);
     return dp[index][target+sum]=plus+minus;
    }
}
// coins change 2 -leetcode 518
class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
               dp[i][j]=-1;
            }
        }
        return helper(coins.length-1,amount,coins);
    }
    public int helper(int index,int target,int arr[]){
        if(target==0){
            return 1;
        }
        if(index==0){
            if(target%arr[0]==0){
                return 1;
            }
            else{return 0;}
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notpick=helper(index-1,target,arr);
        int pick=0;
        if(target>=arr[index]){
            pick=helper(index,target-arr[index],arr);
        }
        return dp[index][target]=pick+notpick;
    }
}
// unbounded knapsack
class Solution {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
    return helper(wt.length-1,W,val,wt);
    }
    public int helper(int indx,int target,int val[],int wt[]){
        if(indx==0){
            if(target%wt[indx]==0){
                int v=target/wt[indx];
                return v*val[0];
            }else{
                return 0;
            }
        }

        int notpick=helper(indx-1,target,val,wt);
        int pick=0;
        if(wt[indx]<=target){
            pick=val[indx]+helper(indx,target-wt[indx],val,wt);
        }
        return Math.max(notpick,pick);
    }
}
// rod cutting -unbounded knapsack
class Solution {
    public int RodCutting(int price[], int n) {
        return helper(price.length - 1, n, price);
    }

    public int helper(int indx, int n, int arr[]) {

        if (indx == 0) {
            return n * arr[0];
        }

        int notpick = helper(indx - 1, n, arr);
        int pick = 0;
        if (n >= indx + 1) {
            pick = arr[indx] + helper(indx, n - (indx + 1), arr);
        }

        return Math.max(pick, notpick);
    }
}
// longest common subsequence - leetcode 1143
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
       return helper(text1.length()-1,text2.length()-1,text1,text2);
    }
    public int helper(int i,int j,String s1, String s2){
       if(i<0 || j<0){
        return 0;
       }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+helper(i-1,j-1,s1,s2);
        }
        else{
            return dp[i][j]= Math.max(helper(i-1,j,s1,s2),helper(i,j-1,s1,s2));
        }
        
    }
}
// print longest common subsequence
class Solution {

    public String longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
// longest common substring
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;   
                }
            }
        }

        return maxLen;
    }
}
// longest palindromic subsequence -leetcode 516
class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        dp=new int[s.length()][s2.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s2.length();j++){
                dp[i][j]=-1;
            }
        }
        return helper(s.length()-1,s2.length()-1,s,s2);
    }
    public int helper(int i,int j,String s1,String s2){
            if(i<0|| j<0){
                return 0;
            }
            if(dp[i][j]!=-1){
                 return dp[i][j];
            }
            if(s1.charAt(i)==s2.charAt(j)){
                return dp[i][j]= 1+helper(i-1,j-1,s1,s2);
            }else{
                return dp[i][j]=Math.max(helper(i-1,j,s1,s2),helper(i,j-1,s1,s2));
            }
        }
}
// Minimum Insertion Steps to Make a String Palindrome
class Solution {
    int dp[][];
    public int minInsertions(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        dp=new int[s.length()][s2.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s2.length();j++){
                dp[i][j]=-1;
            }
        }
        int lps= helper(s.length()-1,s2.length()-1,s,s2);
        return s.length()-lps;
    }
    public int helper(int i,int j,String s1,String s2){
      if(i<0||j<0){
        return 0;
      }
       if(dp[i][j]!=-1){
        return dp[i][j];
       }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+helper(i-1,j-1,s1,s2);
        }else{
              return dp[i][j]=Math.max(helper(i,j-1,s1,s2),helper(i-1,j,s1,s2));
        }
    }
}