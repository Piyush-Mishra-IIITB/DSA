package GreedyAlgo;

public class Question {
    
}
// assign cookies
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l1=g.length;
        int l2=s.length;
        int i=0;
        int j=0;
        int counter=0;
        while(i<l1 && j<l2){
             if(g[i]<=s[j]){
                counter++;
                i++;
                j++;
             }
             else if(g[i]>s[j]){
                j++;
             }
        }
        return counter;

    }
}
// lemonade change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        int i = 0;
        while (i < bills.length) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                five--;
                ten++;
                if (five < 0) return false;
            }
            else { 
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
// jump game 
// leetcode 55
class Solution {
    public boolean canJump(int[] arr) {
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + arr[i]);
            if (maxIndex >= arr.length - 1) {
                return true;
            }
        }
        return true;
    }
}
// brute force of jump-game 2
class Solution {
    public int jump(int[] arr) {
       return helper(0,arr);
       
    }
    public int helper(int ind,int arr[]){
        if(ind>=arr.length-1){
            return 0;
        }
        if(arr[ind]==0){return Integer.MAX_VALUE;}
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr[ind];i++){
           int sub=helper(ind+1,arr);
            if(sub!=Integer.MAX_VALUE){
                min=Math.min(min,sub+1);
            }
        }
        return min;
    }
}