387. First Unique Character in a String

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/

public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++){
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < size; i++){
            if (arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }