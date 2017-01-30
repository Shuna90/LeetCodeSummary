66. Plus One

public int[] plusOne(int[] digits) {
        int carry = 1, size = digits.length;
        for (int i = size - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[size + 1];
        res[0] = 1;
        return res;
    }