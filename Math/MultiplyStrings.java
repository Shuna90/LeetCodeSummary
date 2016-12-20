public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
            return "";
        }
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--){
            int p = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--){
                int q = num2.charAt(j) - '0';
                int sum = arr[(num1.length() - 1 - i) + (num2.length() - 1 - j)] + p * q + carry;
                carry = sum / 10;
                sum = sum % 10;
                arr[(num1.length() - 1 - i) + (num2.length() - 1 - j)] = sum;
            }
            arr[num2.length() + num1.length() - 1 - i] = carry;
            carry = 0;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < (num2.length() + num1.length())){
            sb.insert(0, arr[count++]);
        }
        if (sb.charAt(0) == '0'){
            sb.delete(0, 1);
        }
        return sb.toString();
    }
}Multiply Strings