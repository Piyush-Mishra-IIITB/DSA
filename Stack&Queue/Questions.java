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