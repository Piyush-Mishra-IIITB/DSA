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
