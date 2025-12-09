package Array;

public class TwoPointers {
    
  //2 pointer-leetcode:167
    public int[] twoSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        int[] output = new int[2];

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                output[0] = start+1;
                output[1] = end+1;
                return output;       
            }
            else if (sum > target) {
                end--;
            }
            else {
                start++;
            }
        }

        return new int[]{-1, -1};    
    }
//removal of duplicates from sorted array-1 leetcode:26
    public int removeDuplicates(int[] arr) {
        int total=1;
        int i=0;
        int j=1;
        while(j<arr.length){
            if(arr[j]==arr[j-1]){
                j++;
                continue;
            }
            arr[i+1]=arr[j];
            i++;
            total++;
            j++;
        }
        return total;
    }
    // good question leetcode-977
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        int idx = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[idx] = leftSquare;
                left++;
            } else {
                result[idx] = rightSquare;
                right--;
            }
            idx--;
        }

        return result;
    }
}


    public static void main(String args[]){
      int arr[]={1,2,3,4,5};
      
    }
}
