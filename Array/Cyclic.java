package Array;

public class Cyclic {
    
    // sort the array which contains element from 1 to n
    //the t.c is O(n)
    public static void cyclic(int arr[]){
        int i=0;
        while(i<arr.length){
            int valid_position=arr[i]-1;
            if(arr[i] !=valid_position){
                swap(arr,i,valid_position);
            }else{
                i++;
            }
        }
    }
    public static void swap(int arr[],int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
// leetcode -268
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=(n*(n+1))/2;
        int sum=0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
        }
        return total-sum;
    }
}
// leetcode -448
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

       
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                list.add(j + 1);
            }
        }

        return list;
    }
}
// leetcode -287
class Solution {
    public int findDuplicate(int[] arr) {
        int i=0;
        int n=arr.length;
        while(i<n){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                if(i !=correct){
                    return arr[i];
                }
                i++;
            }
        }
      return -1;
    }
    }
