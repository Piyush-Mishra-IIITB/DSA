package Heap;

import java.util.PriorityQueue;

import javax.swing.tree.TreeNode;

public class Question {
    
}
// heapify algo
public static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        heapify(arr, n, largest);
    }
}
// heap sort
class HeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
// kth largest
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            min.add(nums[i]);
        }
        for(int i=0;i<nums.length-k;i++){
            min.poll();
        }
        return min.peek();
    }
}
// is bt a complete bt

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int length=len(root);
        return helper(root,0,length);
    }
    public boolean helper(TreeNode root,int i,int length){
        if(root==null){
            return true;
        }
        if(i>=length){
            return false;
        }
        else{
            boolean left=helper(root.left,2*i+1,length);
            boolean right=helper(root.right,2*i+2,length);
            return left&& right;
        }
    }
    public int len(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=len(root.left);
        int rh=len(root.right);
        return lh+rh+1;
    }
}
// mincost of rope
class Solution {
    public int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int r : ropes) {
            pq.add(r);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;

            cost += sum;
            pq.add(sum);
        }

        return cost;
    }
}
// leetcode -1508
class Solution {
    public int rangeSum(int[] arr, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                pq.add(sum);
            }
        }

        return helper(pq, left, right);
    }

    public int helper(PriorityQueue<Integer> pq, int left, int right) {
        int MOD = 1000000007;

        int i = 1;
        while (i < left) {
            pq.poll();
            i++;
        }

        long sum = 0;  
        int var = left;

        while (var <= right) {
            sum = (sum + pq.poll()) % MOD;
            var++;
        }

        return (int) sum;
    }
}

