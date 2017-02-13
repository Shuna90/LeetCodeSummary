306. Additive Number

/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/
import java.math.BigInteger;
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int size = num.length();
        for (int i = 1; i <= size / 2; i++){
            for (int j = 1; Math.max(i, j) <= size - i - j; j++){
                if (isValid(i, j, num)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isValid(int i, int j, String num){
        if (num.charAt(0) == '0' && i > 1){
            return false;
        }
        if (num.charAt(i) == '0' && j > 1){
            return false;
        }
        String sum;
        BigInteger b1 = new BigInteger(num.substring(0, i));
        BigInteger b2 = new BigInteger(num.substring(i, i + j));
        for (int index = i + j; index < num.length(); index += sum.length()){
            b2 = b2.add(b1);
            b1 = b2.subtract(b1);
            sum = b2.toString();
            if (!num.startsWith(sum, index)){
                return false;
            }
        }
        return true;
    }
}