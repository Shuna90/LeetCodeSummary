7. Reverse Integer

public int reverse(int x) {
        long res = 0;
        while (x != 0){
            int remain = x % 10;
            res = res * 10 + Long.valueOf(remain);
            if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int)res;
    }