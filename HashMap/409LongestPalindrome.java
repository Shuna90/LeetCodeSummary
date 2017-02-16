409. Longest Palindrome

/*

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

 public int longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> map = new HashSet<Character>();
        int size = s.length();
        int count = 0;
        for (int i = 0; i < size; i++){
            if (map.contains(s.charAt(i))){
                map.remove(s.charAt(i));
                count++;
            }else{
                map.add(s.charAt(i));
            }
        }
        return map.isEmpty() ? count * 2 : count * 2 + 1;
    }