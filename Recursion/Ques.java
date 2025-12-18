package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Ques {
    // all subseq of array
    // leetcode-78
    class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>();     
        helper(0, nums, current, ans);
        return ans;
    }

    private void helper(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current)); 
            return;
        }

        current.add(nums[index]);
        helper(index + 1, nums, current, ans);
        current.remove(current.size() - 1);
        helper(index + 1, nums, current, ans);
    }
}

}
// leetcode-39
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        comb(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void comb(int[] arr, int target, int i,
                      List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == arr.length || target < 0) {
            return;
        }
        list.add(arr[i]);
        comb(arr, target - arr[i], i, list, ans);
        list.remove(list.size() - 1);

        comb(arr, target, i + 1, list, ans);
    }
}
// leetcode -40-loop+skip duplicates
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates,ans,list,0,target);
        return ans;
    }
    public static void comb(int arr[],List<List<Integer>> ans,List<Integer> list,int i,int target){
        if(target==0){
                ans.add(new ArrayList<>(list));
                }      
        
        for(int j=i;j<arr.length;j++){
            if(j>i && arr[j]==arr[j-1]){
                continue;
            }
            if(arr[j]>target){
                break;
            }
            list.add(arr[j]);
            comb(arr,ans,list,j+1,target-arr[j]);
            list.remove(list.size()-1);
        }
    }
}