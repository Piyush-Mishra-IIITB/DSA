package Array;
import java.util.*;

public class Basic {
    public static void linear(int arr[],int n){
      int length=arr.length;
      for(int i=0;i<length;i++){
        if(arr[i]==n){
            System.out.println("found at " + i + " index");
        }
      }
    }
    public static void largest(int arr[]){
        int a=arr[0];
        for(int i=0;i<arr.length;i++){
            if(a<arr[i]){
                a=arr[i];
            }
        }
        System.out.println("largest no. in array is " + a);
    }
public static void wanted_position(int arr[], int n){
//wanted position can be done by 2 method
//one is here and 2nd is too sort the array and return the value on indexing

    int max = Integer.MIN_VALUE;
    int index = -1;

    for(int count = 0; count < n; count++){
        max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }

        // Mark the found max so it won't be picked again
        arr[index] = Integer.MIN_VALUE;
    }

    System.out.println(n + "th largest no. in this array is " + max);
}

public static void binary(int arr[],int n){
    int start=0;
    int end=arr.length-1;
    while(start<=end){
        int mid=(start+end)/2;
        if(mid==n){
            System.out.print("found");
        }
        if (mid>n) {
            end=mid-1; 
        } else {
            start=mid+1;
        }
    }
}
public static void reverse(int arr[]){
    int start=0;
    int end=arr.length-1;
    while(start<end){
        int t=arr[start];
        arr[start]=arr[end];
        arr[end]=t;
        start++;
        end--;
    }
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]);
    }
}
public static void pairs(int arr[]){
    for(int i = 0; i < arr.length; i++){
        for(int j = i + 1; j < arr.length; j++){
            System.out.print("(" + arr[i] + "," + arr[j] + ") ");
        }
        System.out.println();
    }
}
public static void subarray(int arr[]){
//subarray-continous part of array
  for(int i=0;i<arr.length;i++){
  int start=i;
  for(int j=start;j<arr.length;j++){
    int ends=j;
    for(int k=start;k<ends;k++){
        System.out.print(arr[k]);
    }
    System.out.println("");
  }
  }  
}
public static void max_subarray_sum(int arr[]){
    int max=Integer.MIN_VALUE;
    int currsum=0;

    for(int i=0;i<arr.length;i++){
      int start=i;
    for(int j=start;j<arr.length;j++){
       int ends=j;
       currsum=0;
    for(int k=start;k<ends;k++){
        currsum=currsum+arr[k];
        if(currsum>max){
            max=currsum;
        }
    }
  }}
  System.out.println(max);
  
}
    public static void main(String args[]){
int arr[]={1,2,3,4,5};
       linear(arr,5 );
       largest(arr);
       wanted_position(arr, 2);
       binary(arr, 2);
       reverse(arr);
       pairs(arr);
       subarray(arr);
       max_subarray_sum(arr);
    }
}
// leetcode-1672
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        for(int i=0;i<accounts.length;i++){
            int sum=0;
             for(int j=0;j<accounts[i].length;j++){
                sum += accounts[i][j];
             }
             max=Math.max(max,sum);
        }
        return max;
    }
}
//leetcode-1295
class Solution {
    public int findNumbers(int[] arr) {
        
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int digit=0;
            while(arr[i]>0){
                arr[i]=arr[i]/10;
                digit++;
            }
            if(digit%2==0){
                sum++;
            }
        }
        return sum;
    }
}
// duplicate 2
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
// majority ellement 2
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) > nums.length / 3) {
                ans.add(key);
            }
        }
        return ans;
    }
}
// product except self
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int prefix[]=new int[nums.length];
      int suffix[]=new int[nums.length];
      prefix[0]=nums[0];
      for(int i=1;i<nums.length;i++){
        prefix[i]=prefix[i-1]*nums[i];
      }
      suffix[nums.length-1]=nums[nums.length-1];
      for(int i=nums.length-2;i>=0;i--){
        suffix[i]=suffix[i+1]*nums[i];
      }
      int ans[]=new int[nums.length];
      ans[0]=suffix[1];
      ans[nums.length-1]=prefix[nums.length-2];
      for(int i=1;i<nums.length-1;i++){
        ans[i]=prefix[i-1]*suffix[i+1];
      }
      return ans;
    }
}
// leetcode 217
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
      HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for(int value:hm.values()){
            if(value>1){
                return true;
            }
        }
        return false;
}}
// leetcode-217 Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
      HashSet<Integer>hm=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hm.add(nums[i]);
        }
        if(hm.size()==nums.length){
               return false;
        }
        return true;
}}
// leetcode 349 Intersection of 2 array
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        List<Integer> ll = new ArrayList<>();

        for (int val : set) {
            if (set2.contains(val)) {
                ll.add(val);
            }
        }
        int[] ans = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            ans[i] = ll.get(i);
        }

        return ans;
    }
}
// longest consecutive sequence-leetcode 128
class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        TreeSet<Integer>set=new TreeSet<>();
        for(int i=0;i<arr.length;i++){
              set.add(arr[i]);
        }
        Iterator<Integer>it=set.iterator();
        int prev=it.next();
        int maxlen=1;
        int currlen=1;
        while(it.hasNext()){
            int curr=it.next();
            if(curr==prev+1){
                currlen++;
            }else{
                currlen=1;
            }
            maxlen=Math.max(currlen,maxlen);
            prev=curr;
        }
        return maxlen;
    }
}
//350. Intersection of Two Arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ans.add(nums1[i]);
                    nums2[j]=-1;
                    break;
                }
            }
        }
    int n=ans.size();
    int a[]=new int[n];
    for(int i=0;i<n;i++){
        a[i]=ans.get(i);
    }
    return a;
    }
}
// spiral matrix -2 leetcode 54
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int sr = 0, sc = 0;
        int er = n - 1, ec = n - 1;
        int a = 1;

        while (sr <= er && sc <= ec) {

            for (int i = sc; i <= ec; i++) {
                ans[sr][i] = a++;
            }
            for (int j = sr + 1; j <= er; j++) {
                ans[j][ec] = a++;
            }
            if (sr < er) {
                for (int i = ec - 1; i >= sc; i--) {
                    ans[er][i] = a++;
                }
            }
            if (sc < ec) {
                for (int i = er - 1; i >= sr + 1; i--) {
                    ans[i][sc] = a++;
                }
            }

            sr++;
            er--;
            sc++;
            ec--;
        }

        return ans;
    }
}
// 67. Add Binary
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {

            char x = (i >= 0) ? a.charAt(i) : '0';
            char y = (j >= 0) ? b.charAt(j) : '0';

            if (x == '1' && y == '1' && carry == 0) {
                carry = 1;
                ans.append("0");
            } 
            else if (x == '1' && y == '1' && carry == 1) {
                carry = 1;
                ans.append("1");
            } 
            else if (x == '0' && y == '1' && carry == 0) {
                ans.append("1");
            }
            else if (x == '0' && y == '1' && carry == 1) {
                carry = 1;
                ans.append("0");
            } 
            else if (x == '1' && y == '0' && carry == 1) {
                carry = 1;
                ans.append("0");
            } 
            else if (x == '1' && y == '0' && carry == 0) {
                ans.append("1");
            }
            else if (x == '0' && y == '0' && carry == 1) {
                carry = 0;
                ans.append("1");
            }
            else {
                ans.append("0");
            }

            i--;
            j--;
        }

        if (carry == 1) ans.append("1");

        return ans.reverse().toString();
    }
}
