public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String common = prefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++){
            if (strs[i].indexOf(common) != 0){
                common = prefix(common, strs[i]);
            }
        }
        return common;
    }
    public String prefix(String s1, String s2){
        int length = s1.length() < s2.length() ? s1.length() : s2.length();
        int i = 0;
        for (; i < length; i++){
            if (s1.charAt(i) != s2.charAt(i)){
                break;
            }
        }
        return s1.substring(0, i);
    }
}
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        int length = strs.length;
        if (length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[length - 1];
        int size = s1.length() < s2.length() ? s1.length() : s2.length();
        int i = 0;
        for (; i < size && s1.charAt(i) == s2.charAt(i); i++){}
        return s1.substring(0, i);
    }
}