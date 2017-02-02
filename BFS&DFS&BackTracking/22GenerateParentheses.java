22. Generate Parentheses
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backTrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backTrack(List<String> res, String s, int open, int close, int max){
        if (s.length() == max * 2){
            res.add(s);
            return;
        }
        if (open < max){
            backTrack(res, s + "(", open + 1, close, max);
        }
        if (close < open){
            backTrack(res, s + ")", open, close + 1, max);
        }
    }