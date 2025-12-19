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
// leetcode -90
//subset-2
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>();  
        Arrays.sort(nums);   
        helper(0, nums, list, ans);
        return ans;
    }
    public static void helper(int index,int arr[],List<Integer> list,List<List<Integer>> ans){
        
            ans.add(new ArrayList<>(list)); 
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            helper(i+1,arr,list,ans);
            list.remove(list.size()-1);
        }

    }
}
//leetcode 46
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums,ans,list,freq);
        return ans;
    }
    public static void permute(int arr[],List<List<Integer>> ans,List<Integer>list,boolean freq[]){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
        }
        for(int i=0;i<arr.length;i++){
            if(freq[i]==false){
                freq[i]=true;
                list.add(arr[i]);
                permute(arr,ans,list,freq);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}
// swap method of finding all permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        permute(0,nums,ans);
        return ans;
    }
    public static void permute(int index,int arr[],List<List<Integer>> ans){
        if(index==arr.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
         ans.add(new ArrayList<>(list));
         return;
        }
        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            permute(index+1,arr,ans);
            swap(i, index, arr);
        }
    }
    public static void swap(int a,int b,int arr[]){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
// leetcode 47-all uniques permutations
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 
        permute(0, nums, ans);
        return ans;
    }

    private static void permute(int index, int[] arr, List<List<Integer>> ans) {

        if (index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : arr) list.add(num);
            ans.add(list);
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < arr.length; i++) {
            if (used.contains(arr[i])) continue;

            used.add(arr[i]);

            swap(i, index, arr);
            permute(index + 1, arr, ans);
            swap(i, index, arr); 
        }
    }

    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
// n-queens
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n, board, ans);
        return ans;
    }

    private void solve(int col, int n, char[][] board, List<List<String>> ans) {
        if (col == n) {
            ans.add(construct(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, n, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--; c--;
        }
        r = row; c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q') return false;
            c--;
        }
        r = row; c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++; c--;
        }

        return true;
    }

    private List<String> construct(char[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
// n queens -2
class Solution {
    public int totalNQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n, board, ans);
        return ans.size();
    }

    private void solve(int col, int n, char[][] board, List<List<String>> ans) {
        if (col == n) {
            ans.add(construct(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, n, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int r = row, c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--; c--;
        }
        r = row; c = col;
        while (c >= 0) {
            if (board[r][c] == 'Q') return false;
            c--;
        }
        r = row; c = col;
        while (r < n && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++; c--;
        }

        return true;
    }

    private List<String> construct(char[][] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
// leetcode 37-sudoko solver
class Solution {

    public void solveSudoku(char[][] board) {
        solver(board);
    }

    private boolean solver(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;

                            if (solver(board)) return true;

                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {

            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;

            if (board[3*(row/3) + i/3][3*(col/3) + i%3] == c)
                return false;
        }
        return true;
    }
}
// leetcode -36
//validating sudoko
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
    public static boolean solve(char[][] arr){
        for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]== '.'){
                   continue;
                }
                char c=arr[i][j];
                arr[i][j]='.';
                if(isValid(arr,i,j,c)==false){
                   return false;
                }
                arr[i][j]=c;
             }
        }
        return true;
    }
    public static boolean isValid(char[][] board,int row,int col,int c){
        for (int i = 0; i < 9; i++) {

            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;

            if (board[3*(row/3) + i/3][3*(col/3) + i%3] == c)
                return false;
        }
        return true;
    
    }
}
// palindrome partioning 
// letcode -131
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans =new ArrayList<>();
        List<String> list=new ArrayList<>();
        solve(0,s,list,ans);
        return ans;
    }
    public static void solve(int index,String s,List<String> list,List<List<String>>ans){
            if(index==s.length()){
                ans.add(new ArrayList<>(list));
                return;
            }
            for(int i=index;i<s.length();i++){
                if(isPalindrome(s,index,i)){
                    list.add(s.substring(index,i+1));
                    solve(i+1,s,list,ans);
                    list.remove(list.size()-1);
                }
            }
        }
        public static boolean isPalindrome(String s,int start,int end){
            while(start<=end){
                if(s.charAt(start++)!=s.charAt(end--)){
                    return false;
                }
            }
            return true;
        }
}