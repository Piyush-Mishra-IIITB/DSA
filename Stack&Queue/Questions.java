package Stack&Queue;

public class Questions {
    
}
// implementation  of stack using 1 queue
class MyStack {

    Queue<Integer> qq;

    public MyStack() {
        qq = new LinkedList<>();
    }
    
    public void push(int x) {
        int s = qq.size();
        qq.add(x);
        for (int i = 0; i < s; i++) {
            qq.add(qq.remove());
        }
    }
    
    public int pop() {
        return qq.remove();
    }
    
    public int top() {
        return qq.peek();
    }
    
    public boolean empty() {
        return qq.isEmpty();
    }
}
// stack using 2 queue
class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        moveIfNeeded();
        return out.pop();
    }
    
    public int peek() {
        moveIfNeeded();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void moveIfNeeded() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
// valid parentheses-leetcode:20

class Solution {
    public boolean isValid(String s) {
        int size=s.length();
        Stack<Character> ss=new Stack<>();
        for(int i=0;i<size;i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{'|| c=='['){
               ss.push(c);
            }
            
            else{
                if(ss.isEmpty()){return false;}
                char d=ss.pop();
                if(c==')' && d !='('){
                    return false;
                }if(c=='}' && d !='{'){
                    return false;
                }if(c==']' && d !='['){
                    return false;
                }
            }
    }
    return ss.isEmpty();
}}
// leetcode 155
class Pair {
    int val;
    int min;

    Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {

    Stack<Pair> ss;

    public MinStack() {
        ss = new Stack<>();
    }
    
    public void push(int val) {
        if (ss.isEmpty()) {
            ss.push(new Pair(val, val));
        } else {
            ss.push(new Pair(val, Math.min(val, ss.peek().min)));
        }
    }
    
    public void pop() {
        ss.pop();
    }
    
    public int top() {
        return ss.peek().val;
    }
    
    public int getMin() {
        return ss.peek().min;
    }
}
// next greater element-1
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int element = nums1[i];
            int pos = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == element) {
                    pos = j;
                    break;
                }
            }

            ans[i] = -1;
            for (int k = pos + 1; k < nums2.length; k++) {
                if (nums2[k] > element) {
                    ans[i] = nums2[k];
                    break;
                }
            }
        }
        return ans;
    }
}
// next grater element using monotonic stack
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nextGreater);

            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
// leetcode -503
//next greater element 2
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int ans[]=new int[arr.length];
        Stack<Integer> ss=new Stack<>();
        for(int i=2*arr.length-1;i>=0;i--){
            while(!ss.isEmpty() && ss.peek()<=arr[i%arr.length]){
                ss.pop();
            }
            if(i<arr.length){
                if(ss.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=ss.peek();
                }
            }
            ss.push(arr[i%arr.length]);
        }
        return ans;
    }
}
// left smaller element-incr monotonic stack
import java.util.*;
class Main {
    public static int[] leftSmaller(int arr[]){
        int ans[]=new int[arr.length];
        Stack<Integer> ss=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!ss.isEmpty() && ss.peek()>=arr[i]){
                ss.pop();
            }
            ans[i]=ss.isEmpty()?-1:ss.peek();
            ss.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,8,2,4};
        int arr2[]=leftSmaller(arr);
       for(int i=0;i<arr.length;i++){
           System.out.print(arr2[i]);
       }
    }
}
// traping rain water
class Solution {
    public int trap(int[] arr) {
        int total=0;
        int prefix[]=new int[arr.length];
        int suffix[]=new int [arr.length];
        prefix[0]=arr[0];
        suffix[arr.length-1]=arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            prefix[i]=Math.max(prefix[i-1],arr[i]);
        }
        for(int i=arr.length-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]<prefix[i] && arr[i]<suffix[i]){
                total +=Math.min(prefix[i],suffix[i])-arr[i];
            }
        }
        return total;
    }
}
// leetcode 907-sum of subarray Minimums
//find the sum of min of all subarray
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long sum=0;
        int prevSmaller[]=new int [arr.length];
        int nextSmaller[]= new int[arr.length]; 
        Stack<Integer> ss=new Stack<>();
        Stack<Integer>sss=new Stack<>();
        long mod = 1_000_000_007;
        for(int i=0;i<arr.length;i++){
               while(!ss.isEmpty() && arr[i]<arr[ss.peek()]){
                ss.pop();
               }
               if(ss.isEmpty()){
                prevSmaller[i]=-1;
               }
               else{
                prevSmaller[i]=ss.peek();
               }
               ss.push(i);
        }
        for(int i=arr.length-1;i>=0;i--){
               while(!sss.isEmpty() && arr[i]<=arr[sss.peek()]){
                sss.pop();
               }
               if(sss.isEmpty()){
                nextSmaller[i]=arr.length;
               }
               else{
                nextSmaller[i]=sss.peek();
               }
               sss.push(i);
        }
        for(int i=0;i<arr.length;i++){
             int prevIndex=prevSmaller[i];
             int nextIndex=nextSmaller[i];
             long length=(i-prevIndex)%mod*(nextIndex-i)%mod;
             sum +=(length*arr[i])%mod;
        }
        return (int)(sum % mod);
    }
}
// leetcode -2104 sum of subarray ranges
// sum of subarray max-sum of subarray min
class Solution {
    public long subArrayRanges(int[] nums) {
        return (sumSubarrayMaxs(nums)-sumSubarrayMins(nums));
    }
    public long sumSubarrayMaxs(int[] arr) {
        long sum=0;
        int prevSmaller[]=new int [arr.length];
        int nextSmaller[]= new int[arr.length]; 
        Stack<Integer> ss=new Stack<>();
        Stack<Integer>sss=new Stack<>();
        for(int i=0;i<arr.length;i++){
               while(!ss.isEmpty() && arr[i]>arr[ss.peek()]){
                ss.pop();
               }
               if(ss.isEmpty()){
                prevSmaller[i]=-1;
               }
               else{
                prevSmaller[i]=ss.peek();
               }
               ss.push(i);
        }
        for(int i=arr.length-1;i>=0;i--){
               while(!sss.isEmpty() && arr[i]>=arr[sss.peek()]){
                sss.pop();
               }
               if(sss.isEmpty()){
                nextSmaller[i]=arr.length;
               }
               else{
                nextSmaller[i]=sss.peek();
               }
               sss.push(i);
        }
        for(int i=0;i<arr.length;i++){
             int prevIndex=prevSmaller[i];
             int nextIndex=nextSmaller[i];
             long length=(i-prevIndex)*(nextIndex-i);
             sum +=(length*arr[i]);
        }
        return (sum);
    }
    public long sumSubarrayMins(int arr[]){
        long sum=0;
        int prevSmaller[]=new int [arr.length];
        int nextSmaller[]= new int[arr.length]; 
        Stack<Integer> ss=new Stack<>();
        Stack<Integer>sss=new Stack<>();
        for(int i=0;i<arr.length;i++){
               while(!ss.isEmpty() && arr[i]<arr[ss.peek()]){
                ss.pop();
               }
               if(ss.isEmpty()){
                prevSmaller[i]=-1;
               }
               else{
                prevSmaller[i]=ss.peek();
               }
               ss.push(i);
        }
        for(int i=arr.length-1;i>=0;i--){
               while(!sss.isEmpty() && arr[i]<=arr[sss.peek()]){
                sss.pop();
               }
               if(sss.isEmpty()){
                nextSmaller[i]=arr.length;
               }
               else{
                nextSmaller[i]=sss.peek();
               }
               sss.push(i);
        }
        for(int i=0;i<arr.length;i++){
             int prevIndex=prevSmaller[i];
             int nextIndex=nextSmaller[i];
             long length=(i-prevIndex)*(nextIndex-i);
             sum +=(length*arr[i]);
        }
        return (sum);
    }
}
// asteroid collision -leetcode 735
 class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> ss = new Stack<>();
       for(int i=0;i<arr.length;i++){
          if(arr[i]>0){
            ss.push(arr[i]);
          }else{
            int curr=arr[i];
            boolean distroy=false;
            while(!ss.isEmpty() && ss.peek()>0){
                if(ss.peek()<Math.abs(curr)){
                    ss.pop();
                }
                else if(ss.peek()==Math.abs(curr)){
                    ss.pop();
                    distroy=true;
                    break;
                }else{
                    distroy=true;
                    break;
                }
            }
            if(!distroy){
                ss.push(arr[i]);
            }
          }
       }
       int ans[]=new int[ss.size()];
        for(int i=ss.size()-1;i>=0;i--){
             ans[i]=ss.peek();
             ss.pop();
         }
         return ans;
    }
}
// finding largest rectangle using nextSmaller and prevSmaller
// leetcode 84
class Solution {
    public int largestRectangleArea(int[] arr) {
        int pse[]=leftSmaller(arr);
        int nse[]=rightSmaller(arr);
        int total=0;
        for(int i=0;i<arr.length;i++){
             total=Math.max(total,(nse[i]-pse[i]-1)*arr[i]);
        }
        return total;
    }
    public static int[] leftSmaller(int arr[]){
        Stack<Integer> ss=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!ss.isEmpty() && arr[ss.peek()]>=arr[i]){
                ss.pop();
            }
            if(ss.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=ss.peek();
            }
            ss.push(i);
        }
        return ans;
    }public static int[] rightSmaller(int arr[]){
        Stack<Integer> ss1=new Stack<>();
        int ans2[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!ss1.isEmpty() && arr[ss1.peek()]>=arr[i]){
                ss1.pop();
            }
            if(ss1.isEmpty()){
                ans2[i]=arr.length;
            }else{
                ans2[i]=ss1.peek();
            }
            ss1.push(i);
        }
        return ans2;
    }
}
// leetcode-402
//remove k digit
class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Character> ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!ss.isEmpty() && k > 0 && ss.peek() > c) {
                ss.pop();
                k--;
            }
            ss.push(c);
        }
        while (k > 0 && !ss.isEmpty()) {
            ss.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!ss.isEmpty()) {
            sb.append(ss.pop());
        }
        sb.reverse();
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        String result = sb.substring(idx);
        return result.length() == 0 ? "0" : result;
    }
}
// leetcode-85
// maximal rectangle
class Solution {

    public int maximalRectangle(char[][] arr) {
        if (arr == null || arr.length == 0) return 0;

        int rows = arr.length;
        int cols = arr[0].length;

        int[] height = new int[cols];
        int output = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            output = Math.max(output, largestRectangleArea(height));
        }

        return output;
    }

    public int largestRectangleArea(int[] arr) {
        int[] pse = leftSmaller(arr);
        int[] nse = rightSmaller(arr);
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total = Math.max(total, (nse[i] - pse[i] - 1) * arr[i]);
        }
        return total;
    }

    public static int[] leftSmaller(int[] arr) {
        Stack<Integer> ss = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!ss.isEmpty() && arr[ss.peek()] >= arr[i]) {
                ss.pop();
            }
            ans[i] = ss.isEmpty() ? -1 : ss.peek();
            ss.push(i);
        }
        return ans;
    }

    public static int[] rightSmaller(int[] arr) {
        Stack<Integer> ss1 = new Stack<>();
        int[] ans2 = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!ss1.isEmpty() && arr[ss1.peek()] >= arr[i]) {
                ss1.pop();
            }
            ans2[i] = ss1.isEmpty() ? arr.length : ss1.peek();
            ss1.push(i);
        }
        return ans2;
    }
}
// brute force for sliding window maximum leetcode-239
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index=0;
        for(int i=0;i<n-k+1;i++){
            int max=nums[i];
            for(int j=i;j<=i+k-1;j++){
                max=Math.max(nums[j],max);
            }
            result[index]=max;
            index++;
        }
        return result;
    }
}
