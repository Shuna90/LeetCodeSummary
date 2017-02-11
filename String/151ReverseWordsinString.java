151. Reverse Words in a String
/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0;){
            word = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' '){
                word.insert(0, s.charAt(i));
                i--;
            }
            sb.append(word);
            while (i >= 0 && s.charAt(i) == ' '){
                flag = true;
                i--;
            }
            if (flag){
                sb.append(" ");
            }
            flag = false;
        }
        return sb.toString();
    }
}
public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.length() == 0){
            return "";
        }
        String[] arr = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]).append(" ");   
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        s = s.trim();
        String[] arr = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}