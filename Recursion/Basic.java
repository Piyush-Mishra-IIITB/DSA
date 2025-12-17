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
    // 
     public static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String Args[]){
        //print(0,5);
        //print2(5,5);
        fact(5);
    }
}
