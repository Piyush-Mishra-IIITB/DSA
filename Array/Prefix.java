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

//  good question leetcode-560
class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1); 
        int total = 0; 
        int output = 0;

        for (int i = 0; i < arr.length; i++) {

            total += arr[i];  

            int find = total - k;  

            
            if (hm.containsKey(find)) {
                output += hm.get(find);
            }

            
            hm.put(total, hm.getOrDefault(total, 0) + 1);
        }

        return output;
    }
}
