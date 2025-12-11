package Array;

public class Prefix {
    // leetcode-724
    class Solution {
    public int pivotIndex(int[] arr) {
        int total = 0;
        for (int i=0;i<arr.length;i++){
            total +=arr[i];
        }

        int left = 0;

        for (int i = 0; i < arr.length; i++) {
            int right = total - left - arr[i];
            if (left == right) {
                return i;
            }
            left += arr[i];  
        }

        return -1;
    }
}
}
