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
