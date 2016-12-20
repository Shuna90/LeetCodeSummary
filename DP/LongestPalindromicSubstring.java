public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        String res = s.charAt(0) + "";
        int max = 1;
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 1;
        for (int j = 1; j < s.length(); j++){
            for (int i = 0; i <= j; i++){
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[j - 1][i + 1] != 0)){
                    if (j - i <= 2){
                        dp[j][i] = j - i + 1;
                    }else{
                       dp[j][i] = dp[j - 1][i + 1] + 2; 
                    }
                    if (dp[j][i] > max){
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
public class Solution {
    int max = 0;
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        for (int i = 0; i < s.length(); i++){
            check(s, i, i);
            check(s, i, i + 1);
        }
        return res;
    }
    public void check(String s, int i, int j){
        while (i >= 0 && j < s.length()){
            if (s.charAt(i) != s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        if (j - i - 1 > max){
            max = j - i - 1;
            res = s.substring(i + 1, j);
        }
    }
}
public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int max = 0;
        int low = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])){
                    dp[i][j] = true;
                }
                if (dp[i][j] && i - j  + 1 > max){
                    max = i - j + 1;
                    low = j;
                }
            }
        }
        return s.substring(low, low + max);
    }