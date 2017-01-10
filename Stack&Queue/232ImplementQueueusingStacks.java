232. Implement Queue using Stacks
	
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> buff = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (buff.isEmpty()){
            while (!stack.isEmpty()){
                buff.push(stack.pop());
            }
        }
        buff.pop();
    }

    // Get the front element.
    public int peek() {
        if (buff.isEmpty()){
            while (!stack.isEmpty()){
                buff.push(stack.pop());
            }
        }
        return buff.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty() && buff.isEmpty();
    }