155. Min Stack

Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (!minStack.isEmpty()){
            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }else{
            minStack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int x = stack.pop();
        if (x == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }


Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        if (stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }