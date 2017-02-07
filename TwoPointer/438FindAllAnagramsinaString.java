438. Find All Anagrams in a String

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
template for Sliding Window Solution
int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }


public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() < p.length()){
            return res;
        }
        int[] arr = new int[256];
        for (char c : p.toCharArray()){
            arr[c]++;
        }
        
        int left = 0, right = 0, count = p.length();
        while (right < s.length()){
            if (arr[s.charAt(right++)]-- > 0){
                count--;
            }
            if (count == 0){
                res.add(left);
            }
            if (right - left == p.length() && arr[s.charAt(left++)]++ >= 0){
                count++;
            }
        }
        return res;
    }