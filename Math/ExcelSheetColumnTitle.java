public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0){
            return "";
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            char c = (char) ((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            sb.insert(0, c);
        }
        return sb.toString();
    }
}