8. String to Integer (atoi)

public int myAtoi(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        String s = str.trim();
        int size = s.length();
        int index = 0;
        int res = 0;
        boolean flag = false;
        if (s.charAt(index) == '-'){
            index++;
            flag = true;
        }else if (s.charAt(index) == '+'){
            index++;
        }
        while (index < size && s.charAt(index) == '0'){
            index++;
        }
        for (; index < size; index++){
            int c = s.charAt(index) - '0';
            if (c < 0 || c > 9){
                break;
            }
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && c > 7)){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + c;
        }
        return flag ? -res : res;
    }