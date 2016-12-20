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