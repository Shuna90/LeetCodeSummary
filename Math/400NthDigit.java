400. Nth Digit

public int findNthDigit(int n) {
        int len = 1;
        long num = 9;
        int start = 1;
        while (n > num * len){
            n -= num * len;
            len++;
            start *= 10;
            num *= 10;
        }
        long res = (n - 1) / len + start;
        String s = String.valueOf(res);
        return s.charAt((n - 1) % len) - '0';
    }