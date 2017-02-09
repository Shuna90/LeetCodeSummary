17. Letter Combinations of a Phone Number

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/


private static final String[] arr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        helper(digits, "", 0, res);
        return res;
    }
    public void helper(String digits, String s, int pos, List<String> res){
        if (pos >= digits.length()){
            res.add(s);
            return;
        }
        String letters = arr[digits.charAt(pos) - '0'];
        for (int i = 0; i < letters.length(); i++){
            helper(digits, s + letters.charAt(i), pos + 1, res);
        }
    }
