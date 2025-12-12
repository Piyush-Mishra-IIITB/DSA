package Array;

public class Cyclic {
    
    // sort the array which contains element from 1 to n
    //the t.c is O(n)
    public static void cyclic(int arr[]){
        int i=0;
        while(i<arr.length){
            int valid_position=arr[i]-1;
            if(arr[i] !=valid_position){
                swap(arr,i,valid_position);
            }else{
                i++;
            }
        }
    }
    public static void swap(int arr[],int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
// leetcode -268
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=(n*(n+1))/2;
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
        }
        return total-sum;
    }
}