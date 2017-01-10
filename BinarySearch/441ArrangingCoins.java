441. Arranging Coins

public int arrangeCoins(int n) {
        int start = 1, end = n;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if ((0.5 * mid * mid + 0.5 * mid) <= n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start - 1;
    }