public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> value = new Stack<Integer>();
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        for (int i = 0; i < tokens.length; i++){
            String tmp = tokens[i];
            if (tmp.equals("+")){
                int v1 = value.pop();
                int v2 = value.pop();
                value.push(v1 + v2);
            }else if (tmp.equals("-")){
                int v1 = value.pop();
                int v2 = value.pop();
                value.push(v2 - v1);
            }else if (tmp.equals("/")){
                int v1 = value.pop();
                int v2 = value.pop();
                value.push(v2 / v1);
            }else if (tmp.equals("*")){
                int v1 = value.pop();
                int v2 = value.pop();
                value.push(v1 * v2);
            }else{
                int tmpValue = Integer.parseInt(tmp);
                value.push(tmpValue);
            }
        }
        return value.pop();
    }
}