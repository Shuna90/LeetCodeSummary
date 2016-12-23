415. Add Strings
public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--){
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int n = n1 + n2 + carry;
            if (n >= 10){
                carry = n / 10;
                n = n % 10;
            }else{
                carry = 0;
            }
            sb.insert(0, n);
        }
        return sb.toString();
    }