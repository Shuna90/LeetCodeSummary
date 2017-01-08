20. Valid Parentheses

public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s == null || s.length() == 0){
            return true;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            }else if(c == ']' && !stack.empty() && stack.peek() == '['){
                stack.pop();
            }else if(c == '}' && !stack.empty() && stack.peek() == '{'){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.empty();
    }