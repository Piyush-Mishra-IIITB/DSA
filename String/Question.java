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
// longest common prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        StringBuilder ss = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String a = ss.toString();   
            String b = strs[i];

            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    break;
                }
                temp.append(a.charAt(j));
            }

            ss = temp; 

            if (ss.length() == 0) {
                return "";
            }
        }

        return ss.toString();
    }
}
// isomorphic strings
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>ss=new HashMap<>();
        HashMap<Character,Character>ss1=new HashMap<>();
        if(t.length()!=s.length()){
            return false;
        }
        for(int i=0;i<t.length();i++){
            if(ss.containsKey(s.charAt(i))){
                char a=ss.get(s.charAt(i));
                if(t.charAt(i)!=a){
                    return false;
                }
                ss.put(s.charAt(i),a);
            }else{
                ss.put(s.charAt(i),t.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            
            if(ss1.containsKey(t.charAt(i))){
                char a=ss1.get(t.charAt(i));
                if(s.charAt(i)!=a){
                    return false;
                }
                ss1.put(t.charAt(i),a);
            }else{
                ss1.put(t.charAt(i),s.charAt(i));
            }
        }
        return true;
    }
}
// rotate String-leetcode 796
class Solution {
    public boolean rotateString(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        String rotate=s;
        for(int i=0;i<s.length();i++){
             if(rotate.equals(t)){
                return true;
             }
             rotate=rotate.substring(1)+rotate.charAt(0);
        }
        return false;
    }
}
// sort character by frequency-leetcode 451
class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
// max nesting depth of paranthesis-leetcode 1614
class Solution {
    public int maxDepth(String s) {
      int depth=0;
      int maxdepth=0;
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c=='('){
            depth++;
            maxdepth=Math.max(depth,maxdepth);
        }
        else if(c==')'){
            depth--;
        }
      }
      return maxdepth;
    }
}
// leetcode 14
class Solution {
    public int romanToInt(String s) {

        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = 0;

            char c = s.charAt(i);
            if (c == 'I') curr = 1;
            else if (c == 'V') curr = 5;
            else if (c == 'X') curr = 10;
            else if (c == 'L') curr = 50;
            else if (c == 'C') curr = 100;
            else if (c == 'D') curr = 500;
            else if (c == 'M') curr = 1000;

            if (curr < prev) {
                sum -= curr;
            } else {
                sum += curr;
            }

            prev = curr;
        }

        return sum;
    }
}
// leetcode 8
class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        if (s.length() == 0) return 0;

        StringBuilder ss = new StringBuilder();
        int i = 0;

        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            ss.append(s.charAt(i));
            i++;
        }
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            ss.append(c);
            i++;
        }
        if (ss.length() == 0 || ss.toString().equals("-") || ss.toString().equals("+")) {
            return 0;
        }
        try {
            return Integer.parseInt(ss.toString());
        } catch (NumberFormatException e) {
            return ss.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
// leetcode 58
class Solution {
    public int lengthOfLastWord(String s) {
        int out=0;
        s=s.trim();
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c==' '){
                break;
            }
            out++;
        }
        return out;
    }
}
// find the index of the first occurrence in a string
// leetcode 28
class Solution {
    public int strStr(String s, String t) {
        if(t.length()>s.length()){
            return -1;
        }
        int n=s.length();
        int m=t.length();
        int i=0;
        int j=m;
        while(j<=n){
            String ss=s.substring(i,j);
            if(ss.equals(t)){
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}
// leetcode-3
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}