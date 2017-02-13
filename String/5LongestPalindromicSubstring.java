5. Longest Palindromic Substring

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

int max = 0, low = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        for (int i = 0; i < s.length(); i++){
            check(s, i, i);
            check(s, i, i + 1);
        }
        return s.substring(low, low + max);
    }
    public void check(String s, int l, int h){
        int size = s.length();
        while (l >= 0 && h < size && s.charAt(l) == s.charAt(h)){
            l--;
            h++;
        }
        if (max < h - l - 1){
            low = l + 1;
            max = h - l - 1;
        }
    }