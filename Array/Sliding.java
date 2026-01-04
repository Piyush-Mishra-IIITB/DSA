package Array;

public class Sliding {
    // max sum of subarray of size k
    public static int max_sum(int arr[],int k){
       int low=0;
       int high=k-1;
       int sum=0;
       int result=0;
       for(int i=low;i<=high;i++){
            sum += arr[i];
       }
       while(high<arr.length-1){
        result=Math.max(sum,result);
        if(high==arr.length){
            break;
        }
        sum=sum-arr[low];
        low++;
        high++;
        sum=sum+arr[high];
        
       }
       return result;
    }
    // min size subbaray whose sum>=target leetcode:209
class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int low=0;
        int high=0;
        int currsum=0;
        int length=Integer.MAX_VALUE;
        
            while(high<arr.length){
             currsum=currsum+arr[high];
             while(currsum>=target){
                int len=(high-low)+1;
                length=Math.min(len,length);
                currsum=currsum-arr[low];
                low++;
             }
             high++;
        }
        return (length == Integer.MAX_VALUE) ? 0 : length;
        
        }
    }
    // leetcode 904-fruits into the basket
    import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        Map<Integer, Integer> count = new HashMap<>();
        int low = 0;
        int res = 0;
        int n = fruits.length;

        for (int high = 0; high < n; high++) {
            count.put(fruits[high], count.getOrDefault(fruits[high], 0) + 1);

            while (count.size() > 2) {
                int leftFruit = fruits[low];
                count.put(leftFruit, count.get(leftFruit) - 1);
                if (count.get(leftFruit) == 0) {
                    count.remove(leftFruit);
                }
                low++;
            }

            int len = high - low + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}
// leetcode -3
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int low = 0, res = -1;
        Map<Character, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // shrink window if more than k unique
            while (freq.size() > k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0)
                    freq.remove(leftChar);
                low++;
            }

            
            if (freq.size() == k) {
                res = Math.max(res, high - low + 1);
            }
        }

        return res;



}
// variable sliding window
// leetcode-209
class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int i=0;
        int sum=0;
        int out=Integer.MAX_VALUE;
        for(int j=0;j<arr.length;j++){
            sum=sum+arr[j];
            while(sum>=target){
                sum=sum-arr[i];
                int length=j-i+1;
                out=Math.min(out,length);
                i++;
            }
        }
        return (out==Integer.MAX_VALUE)? 0:out;
    }
    }
// leetcode 643
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int low=0;
        int high=k-1;
        int sum=0;
        for(int i=low;i<=high;i++){
            sum=sum+nums[i];
        }
        double maxSum=sum;
        while(high+1 <nums.length){
            sum=sum-nums[low];
            low++;
            high++;
            sum=sum+nums[high];
            maxSum=Math.max(sum,maxSum);
        }
     return maxSum/k;
    }
}