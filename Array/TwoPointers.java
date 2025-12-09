package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
// 3 sum-leetcode-15
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // skip duplicates for i
            }

            int target = -arr[i];
            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == target) {
                    result.add(Arrays.asList(arr[i], arr[start], arr[end]));

                    start++;
                    end--;

                    
                    while (start<end && arr[start] == arr[start - 1]) {
                        start++;
                    }

                    
                    while (start < end && arr[end] == arr[end + 1]) {
                        end--;
                    }

                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return result;
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  
        
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;  
                }
            }
        }

        return closest;
    }

}

// dutch national flag
class Solution {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{  
                swap(arr, mid, high);
                high--;
            }
        }
    }
}

    public static void main(String args[]){
      int arr[]={1,2,3,4,5};
      
    }
}
