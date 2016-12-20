class MyStack {
    // Push element x onto stack.
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int top;
    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1){
            top = q1.poll();
            q2.offer(top);
        }
        q1.poll();
        Queue<Integer> tmp = q2;
        q2 = q1;
        q1 = tmp;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}