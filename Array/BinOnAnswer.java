package Array;

public class BinOnAnswer {
// sqrt of a number
    class Main {
    public static int sqqrt(int n){
        int start=1;
        int end=n;
        int ans=1;
        while(start<end){
            int mid=(start+end)/2;
            if(mid*mid<=n){
                ans=mid;
                start=mid+1;
            }
            else if(mid*mid>n){
                end=mid-1;
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(sqqrt(49));
    }
}
    
}
//nth root of integer 
// use Math.pow()
class Main {
    public static int sqqrt(int n,int nth){
        int start=1;
        int end=n;
        int ans=1;
        while(start<end){
            int mid=(start+end)/2;
            if(Math.pow(mid,nth)<=n){
                ans=mid;
                start=mid+1;
            }
            else if(Math.pow(mid,nth)>n){
                end=mid-1;
            }
            
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.print(sqqrt(8,3));
    }
}
// leetcode 875
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=Integer.MIN_VALUE;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<piles.length;i++){
             end=Math.max(end,piles[i]);
        }
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(value(piles,mid)<=h){
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else if(value(piles,mid)>h){
                start=mid+1;
            }
        }
        return ans;
        

    }
    public static int value(int arr[],int mid){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans +=Math.ceil((double)arr[i]/mid);
        }
        return ans;
    }
}
// lletcode 1482 brute force
class Solution {
    public int minDays(int[] nums, int m, int k) {
        int start=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            start=Math.min(start,nums[i]);
        }
        int end=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            end=Math.max(end,nums[i]);
        }
        for(int i=start;i<=end;i++){
            if(possible(nums,i,m,k)==true){
                return i;
            }
        }
        return -1;
        
    }
    public static boolean possible(int arr[],int day,int m,int k){
        int count=0;
        int bookies=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                bookies +=count/k;
                count=0;
            }

        }
        bookies +=count/k;
        if (bookies>=m){
            return true;
        }
        return false;
    }
}
// optimal sol usig binary search
class Solution {
    public int minDays(int[] nums, int m, int k) {
        if ((long) nums.length < (long) m * k) {
            return -1;
        }
        int start=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            start=Math.min(start,nums[i]);
        }
        int end=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            end=Math.max(end,nums[i]);
        }
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(nums,mid,m,k)>=m){
                ans=Math.min(ans,mid);
                end=mid-1;
            }else{
                start=mid+1;
            }
            
        }
        return ans;
        
    }
    public static int possible(int arr[],int day,int m,int k){
        int count=0;
        int bookies=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }
            else{
                bookies +=count/k;
                count=0;
            }

        }
        bookies +=count/k;
        return bookies;
    }
}