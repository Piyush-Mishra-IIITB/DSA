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
