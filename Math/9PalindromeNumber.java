9. Palindrome Number
public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int res = 0;
        int n = x;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res == n;
    }