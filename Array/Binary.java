package Array;

public class Binary {
    //binary normal
    public static int binary(int arr[], int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==target){
                return mid;
            }
            else if(mid>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}
// order agnostic binary search
public static int orderAgnostic(int arr[],int target){
    int start=0;
    int end=arr.length-1;
    boolean isAsc=arr[start]<arr[end];
    while(start<=end){
        int mid=start+(end-start/2);
          if(arr[mid]==target){
            return mid;
          }
          if(isAsc){
            if(arr[mid]>target){
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
          }
          else{
            if(arr[mid]<target){
                end=mid-1;
            }
            else if(arr[mid]>target){
                start=mid+1;
            }
          }
        
    }
}
//ceiling of a number
//if arr is ascending sorted celing is arr[start]
//if arr is descending sorted ceiling is arr[end]
class Main {

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (target > arr[end]) {
            return -1; 
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return arr[start];
    }
    // floor of a number

    public static int floor(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;

    if (target < arr[0]) {
        return -1; 
    }

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return arr[mid];
        }
        else if (arr[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
    }
    return arr[end];
}
//leetcode-744
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]<=target){
                start=mid+1;
            }
            else if(letters[mid]>target){
                end=mid-1;
            }
        }
        return letters[start%letters.length];
    }
}
// leetcode -34 best question till now of binary search

class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] output = {-1, -1};

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                output[0] = mid;
                end = mid - 1;      
            } 
            else if (arr[mid] > target) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                output[1] = mid;
                start = mid + 1;   
            } 
            else if (arr[mid] > target) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        return output;
    }
}
// using binary without using arr.length means the arr is of infinite index

public static int ans(int arr[],int target){
    int start=0;
    int end=1;
    while(target>end){
        int temp=end+1;
        end=end+(end-start+1)*2;
    }
    return binary(arr,target,start,end);
}
public static int binary(int arr[],int target,int start,int end){
    while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]>target){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
    }
}
// leetcode -162 & leetcode-852
class Solution {
    public int findPeakElement(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }
}