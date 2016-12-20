public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        boolean flag = (dividend ^ divisor) >>> 31 == 1;
        long d = Math.abs((long)dividend);
        long s = Math.abs((long)divisor);
        long res = 0;
        while (d >= s){
            long base = s;
            for (int i = 0; (base << i) <= d; i++){
                res += 1 << i;
                d -= base << i;
            }
        }
        if (flag){
            res = - res;
        }
        if (res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)res;
    }
}