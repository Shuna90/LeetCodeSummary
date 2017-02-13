395. Longest Substring with At Least K Repeating Characters

/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        return helper(arr, k, 0, arr.length);
    }
    
    public int helper(char[] arr, int k, int start, int end){
        if (end - start < k){
            return 0;
        }
        int[] count = new int[26];
        for (int i = start; i < end; i++){
            count[arr[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (count[i] > 0 && count[i] < k){
                for (int j = start; j < end; j++){
                    if (arr[j] - 'a' == i){
                        int left = helper(arr, k, start, j);
                        int right = helper(arr, k, j + 1, end);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }