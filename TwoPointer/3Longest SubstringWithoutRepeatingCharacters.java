3. Longest Substring Without Repeating Characters

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int size = arr.length;
        int left = 0, right = 0;
        int max = 0;
        while (right < size){
            if (!set.contains(arr[right])){
                set.add(arr[right++]);
                max = Math.max(max, right - left);
            }else{
                set.remove(arr[left++]);
            }
        }
        return max;
    }