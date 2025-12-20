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
