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
       //linear(arr,5 );
       //largest(arr);
       //wanted_position(arr, 2);
       //binary(arr, 2);
       //reverse(arr);
       //pairs(arr);
       //subarray(arr);
       max_subarray_sum(arr);
    }
}
