186. Reverse Words in a String II

/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array
*/


public void reverseWords(char[] s) {
        if (s == null || s.length == 0){
            return;
        }
        int i = 0;
        while (i < s.length){
            int j = i; 
            for (; j < s.length && s[j] != ' '; j++){}
            reverse(s, i, j - 1);
            i = j + 1;
        }
        reverse(s, 0, s.length - 1);
    }
    public void reverse(char[] s, int i, int j){
        while (i < j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }