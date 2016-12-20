public class Solution {
    public int mySqrt(int x) {
        if (x < 0){
            return -1;
        }
        if (x == 0 || x == 1){
            return x;
        }
        int low = 0, high = x;
        int diff = x;
        int res = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int half = x / mid;
            if (mid <= half && (x / (mid + 1) < (mid + 1))){
                return mid;
            }else if (mid < half){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
}