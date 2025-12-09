package Array;
public class Striver{

     public static boolean sorted_or_not(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {  
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;   
    }

public static void reverse_in_group(int arr[], int a) {
    // good question
    int n = arr.length;
    for (int i = 0; i < n; i += a) {
        int start = i;  
        int end = Math.min(n - 1, i + a - 1);
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
public static void rotate(int arr[],int d){
    int n=arr.length;
    for(int j=0;j<d;j++){
        for(int i=0;i<n-1;i++){
        int temp=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=temp;

    }
}}
    public static void main(String args[]){
     int arr[]={1,2,3,4,5};
     //System.out.println(sorted_or_not(arr));
     //reverse_in_group(arr, 3);
     //rotate(arr, 2);
     for(int i=0;i<arr.length;i++){
       System.out.print(arr[i]);
     }

    }
}