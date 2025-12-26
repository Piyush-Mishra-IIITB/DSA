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