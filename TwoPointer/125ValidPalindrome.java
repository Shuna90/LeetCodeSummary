125. Valid Palindrome
public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end){
            while (start < end && !Character.isLetterOrDigit(arr[start])){
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(arr[end])){
                end--;
            }
            if (arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }