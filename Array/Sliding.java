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

    public static void main(String args[]){

    }
}
