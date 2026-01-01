package Array;
import java.util.*;

public class Basic {
    public static void linear(int arr[],int n){
      int length=arr.length;
      for(int i=0;i<length;i++){
        if(arr[i]==n){
            System.out.println("found at " + i + " index");
        }
      }
    }
    public static void largest(int arr[]){
        int a=arr[0];
        for(int i=0;i<arr.length;i++){
            if(a<arr[i]){
                a=arr[i];
            }
        }
        System.out.println("largest no. in array is " + a);
    }
public static void wanted_position(int arr[], int n){
//wanted position can be done by 2 method
//one is here and 2nd is too sort the array and return the value on indexing

    int max = Integer.MIN_VALUE;
    int index = -1;

    for(int count = 0; count < n; count++){
        max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }

        // Mark the found max so it won't be picked again
        arr[index] = Integer.MIN_VALUE;
    }

    System.out.println(n + "th largest no. in this array is " + max);
}

public static void binary(int arr[],int n){
    int start=0;
    int end=arr.length-1;
    while(start<=end){
        int mid=(start+end)/2;
        if(mid==n){
            System.out.print("found");
        }
        if (mid>n) {
            end=mid-1; 
        } else {
            start=mid+1;
        }
    }
}
public static void reverse(int arr[]){
    int start=0;
    int end=arr.length-1;
    while(start<end){
        int t=arr[start];
        arr[start]=arr[end];
        arr[end]=t;
        start++;
        end--;
    }
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]);
    }
}
public static void pairs(int arr[]){
    for(int i = 0; i < arr.length; i++){
        for(int j = i + 1; j < arr.length; j++){
            System.out.print("(" + arr[i] + "," + arr[j] + ") ");
        }
        System.out.println();
    }
}
public static void subarray(int arr[]){
//subarray-continous part of array
  for(int i=0;i<arr.length;i++){
  int start=i;
  for(int j=start;j<arr.length;j++){
    int ends=j;
    for(int k=start;k<ends;k++){
        System.out.print(arr[k]);
    }
    System.out.println("");
  }
  }  
}
public static void max_subarray_sum(int arr[]){
    int max=Integer.MIN_VALUE;
    int currsum=0;

    for(int i=0;i<arr.length;i++){
      int start=i;
    for(int j=start;j<arr.length;j++){
       int ends=j;
       currsum=0;
    for(int k=start;k<ends;k++){
        currsum=currsum+arr[k];
        if(currsum>max){
            max=currsum;
        }
    }
  }}
  System.out.println(max);
  
}
    public static void main(String args[]){
int arr[]={1,2,3,4,5};
       linear(arr,5 );
       largest(arr);
       wanted_position(arr, 2);
       binary(arr, 2);
       reverse(arr);
       pairs(arr);
       subarray(arr);
       max_subarray_sum(arr);
    }
}
// leetcode-1672
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
             for(int j=0;j<accounts[i].length;j++){
                sum += accounts[i][j];
             }
             max=Math.max(max,sum);
        }
        return max;
    }
}
//leetcode-1295
class Solution {
    public int findNumbers(int[] arr) {
        
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int digit=0;
            while(arr[i]>0){
                arr[i]=arr[i]/10;
                digit++;
            }
            if(digit%2==0){
                sum++;
            }
        }
        return sum;
    }
}
// duplicate 2
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
// majority ellement 2
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) > nums.length / 3) {
                ans.add(key);
            }
        }
        return ans;
    }
}
// product except self
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int prefix[]=new int[nums.length];
      int suffix[]=new int[nums.length];
      prefix[0]=nums[0];
      for(int i=1;i<nums.length;i++){
        prefix[i]=prefix[i-1]*nums[i];
      }
      suffix[nums.length-1]=nums[nums.length-1];
      for(int i=nums.length-2;i>=0;i--){
        suffix[i]=suffix[i+1]*nums[i];
      }
      int ans[]=new int[nums.length];
      ans[0]=suffix[1];
      ans[nums.length-1]=prefix[nums.length-2];
      for(int i=1;i<nums.length-1;i++){
        ans[i]=prefix[i-1]*suffix[i+1];
      }
      return ans;
    }
}