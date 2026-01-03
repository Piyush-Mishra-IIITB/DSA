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