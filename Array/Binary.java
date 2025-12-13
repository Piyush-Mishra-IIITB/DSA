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