public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            count = count * 26 + (s.charAt(i) - 'A' + 1);
        }
        return count;
    }
}