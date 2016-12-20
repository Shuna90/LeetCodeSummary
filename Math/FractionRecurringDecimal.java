public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0){
            return "";
        }
        if (numerator == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((numerator ^ denominator) >>> 31 == 1 ? "-" : "");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        long quo = n / d;
        long remainder = n % d;
        sb.append(quo);
        if (remainder == 0){
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int index = sb.length();
        map.put(remainder, index++);
        while (remainder != 0){
            quo = remainder * 10 / d;
            remainder = remainder * 10 % d;
            sb.append(quo);
            if (!map.containsKey(remainder)){
                map.put(remainder, index++);
            }else{
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            }
        }
        return sb.toString();
    }
}