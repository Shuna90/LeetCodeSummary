public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] arr = new int[s.length() + 1];
        arr[0] = 1;
        if (s.charAt(0) != '0'){
            arr[1] = 1;
        }
        for (int i = 1; i < s.length(); i++){
            int pre = s.charAt(i - 1) - '0';
            int now = s.charAt(i) - '0';
            int cal = pre * 10 + now;
            if (now != 0){
                arr[i + 1] = arr[i];
            }
            if (cal >= 10 && cal <= 26){
                arr[i + 1] += arr[i - 1];
            }
        }
        return arr[arr.length - 1];
    }
}