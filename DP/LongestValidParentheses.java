public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '('){
                stack.push(i);
            }else if (!stack.isEmpty()){
                int index = stack.pop();
                dp[i] = i - index + 1;
                if (index > 1){
                    dp[i] += dp[index - 1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}