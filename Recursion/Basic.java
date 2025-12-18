package Recursion;

public class Basic {
    // print 1 to n from recursion
    public static void print(int i,int n){
        if (i==n){
            return;
        }
        System.out.print(i);
        print(i+1,n);
    }
    // print 1 to n from backtracking
    public static void print2(int i,int n){
        if(i==0){
            return;
        }
        print2(i-1,n);
        System.out.print(i);
    }
     public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void reverse(int left,int right,int arr[]){
        if(left>=right){
            return;
        }
        swap(left,right,arr);
        reverse(left+1,right-1,arr);
    }
    public static void swap(int a,int b,int arr[]){
        int temp=arr[a];
       arr[a]=arr[b];
        arr[b]=temp;
    } 
    public static int fibonacci(int n){
        if(n==0||n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String Args[]){
        //print(0,5);
        //print2(5,5);
        //fact(5);
       // int arr[]={1,2,3,4,5};
       // reverse(0,4,arr);
        //for(int i=0;i<arr.length;i++){
          // System.out.print(fibonacci(10));
       // }
    }
}
