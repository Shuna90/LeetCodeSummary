225. Implement Stack using Queues

Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size-- > 1){
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }