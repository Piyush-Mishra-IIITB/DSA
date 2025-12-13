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