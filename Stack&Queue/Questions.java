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
