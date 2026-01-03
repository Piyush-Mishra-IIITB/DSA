package String;

public class Question {
    
}
// leetcode 151-reverse a word in a string
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.reverse();
        int i = 0;
        int n = sb.length();

        while (i < n) {
            if (sb.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;
            while (i < n && sb.charAt(i) != ' ') {
                i++;
            }

            int end = i - 1;
            reverse(sb, start, end);
        }

        return removeSpace(sb);
    }

    public void reverse(StringBuilder sb, int s, int e) {
        while (s < e) {
            char c = sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));
            sb.setCharAt(e, c);
            s++;
            e--;
        }
    }
    public String removeSpace(StringBuilder ss) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int n = ss.length();

        while (i < n) {

            while (i < n && ss.charAt(i) == ' ') {
                i++;
            }
            while (i < n && ss.charAt(i) != ' ') {
                res.append(ss.charAt(i));
                i++;
            }
            if (i < n) {
                res.append(' ');
            }
        }
        if (res.length() > 0 && res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }
}
//Largest Odd Number in String
class Solution {
    public String largestOddNumber(String num) {
       for(int i=num.length()-1;i>=0;i--){
        int c=num.charAt(i)-'0';
        if(c%2!=0){
            return num.substring(0,i+1);
        }
       }
       return "";
    }
}