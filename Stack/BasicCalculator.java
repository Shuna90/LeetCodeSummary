public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> stack2 = new Stack<Character>();
        for (int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if (c == ' '){
            	continue;
            }
            if (c == '('){
                int sum = stack.pop();
                while (!stack2.isEmpty() && !stack2.peek().equals(')')){
                    char expression = stack2.pop();
                    if (expression == '+'){
                    	sum += stack.pop();
                    }else{
                    	sum -= stack.pop();
                    }
                }
                stack2.pop();
                stack.push(sum);
            }else if (c == ')' || c == '+' || c == '-'){
                stack2.push(c);
            }else if (Character.isDigit(c)){
            	StringBuilder tmp = new StringBuilder();
            	while (i >= 0 && Character.isDigit(s.charAt(i))){
            		tmp.insert(0, s.charAt(i));
            		i--;
            	}
            	i++;
            	stack.push(Integer.parseInt(tmp.toString()));
            }
        }
        int sum = stack.pop();
        while (!stack.isEmpty()){
        	char expression = stack2.pop();
            if (expression == '+'){
            	sum += stack.pop();
            }else{
            	sum -= stack.pop();
            }
        } 
        return sum;
    }
}