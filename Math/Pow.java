public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || n == 0){
            return 1;
        }
        if (n == 1 || x == 1){
            return x;
        }
        if (x < 0){
            if (n % 2 == 0){
                return myPow(-x,n);
            }else{
                return -myPow(-x, n);
            }
        }
        if (n < 0){
            if (n == Integer.MIN_VALUE){
                return 1 / (myPow(x, Integer.MAX_VALUE) * x);
            }else{
                return 1 / myPow(x, -n);
            }
        }
        
        double half = myPow(x, n / 2);
        if (n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}