import java.util.*;
class MyQueue {
    Deque<Integer> in = new ArrayDeque<>();
    Deque<Integer> out = new ArrayDeque<>();
    public MyQueue() {

    }

    public void push(int x) {
        in.push(x);
    }
    void in2out() {
        if (out == null) {
            while (!in.isEmpty()) {
                System.out.println(in.size());
                out.push(in.pop());
            }
        }
    }
    public int pop() {
        in2out();
        return out.pop();

    }

    public int peek() {
        in2out();
        return out.peek();
    }

    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
