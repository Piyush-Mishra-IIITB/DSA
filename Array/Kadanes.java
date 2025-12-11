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


    // leetcode-152
    class Solution {
    public int maxProduct(int[] arr) {
        int min_end=arr[0];
        int max_end=arr[0];
        int product=arr[0];

        for(int i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=max_end*arr[i];
            int v3=min_end*arr[i];
            max_end=Math.max(v1,Math.max(v2,v3));
            min_end=Math.min(v1,Math.min(v2,v3));
            product=Math.max(product,Math.max(max_end,min_end));
        }

        return product;
    }
    // good question -maximum subarray sum with one deletion
    // leetcode-1186
    class Solution {
    public int maximumSum(int[] arr) {
        int no_delete = arr[0];                
        int one_delete = Integer.MIN_VALUE;     
        int result = arr[0];                   

        for (int i = 1; i < arr.length; i++) {
            int prevNo = no_delete;
            int prevOne = one_delete;

          
            no_delete = Math.max(prevNo + arr[i], arr[i]);

           
            int extendDeleted = (prevOne == Integer.MIN_VALUE) 
                                ? Integer.MIN_VALUE 
                                : prevOne + arr[i];

            one_delete = Math.max(extendDeleted, prevNo);

            
            result = Math.max(result, Math.max(no_delete, one_delete));
        }

        return result;
    }
}


}
}
}
