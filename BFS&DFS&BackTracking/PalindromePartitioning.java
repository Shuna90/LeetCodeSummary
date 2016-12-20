public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        if (s == null || s.length() == 0){
            return res;
        }
        List<String> list = new LinkedList<String>();
        boolean[][] palindrome = palindrome(s);
        partitionUtil(s, res, list, 0, palindrome);
        return res;
    }
    
    public void partitionUtil(String s, List<List<String>> res, List<String> list, int index, boolean[][] palindrome){
        if (index == s.length()){
            res.add(new LinkedList<String>(list));
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (palindrome[index][i]){
                list.add(s.substring(index, i + 1));
                partitionUtil(s, res, list, i + 1, palindrome);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean[][] palindrome(String s){
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j <= i; j++){
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
                    dp[j][i] = true;
                }
            }
        }
        return dp;
    }
}