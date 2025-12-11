package Array;

public class Kadanes {
    
    //leetcode-53
    class Solution {
    public int maxSubArray(int[] arr) {
        int best_end=arr[0];
        int sum=arr[0];
        for(int i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=best_end+arr[i];
            best_end=Math.max(v1,v2);
            sum=Math.max(sum,best_end);
        }
        return sum;
    }
}
}
