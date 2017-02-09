8. String to Integer (atoi)

/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
*/

ppublic int myAtoi(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        String s = str.trim();
        int size = s.length();
        int index = 0, sign = 1, res = 0;
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < size && s.charAt(index) == '0'){
            index++;
        }
        for (; index < size; index++){
            int c = s.charAt(index) - '0';
            if (c > 9 || c < 0){
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && c > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c;
        }
        return sign * res;
    }