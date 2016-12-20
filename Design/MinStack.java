class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int tmp = stack.pop();
        if (tmp == min.peek()){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
