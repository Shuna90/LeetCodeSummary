12. Integer to Roman

/*

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Company Tags
*/

public String intToRoman(int num) {
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] string = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < value.length; i++){
        	while (num >= value[i]){
        	    num -= value[i];
        	    sb.append(string[i]);
        	}
        }
        return sb.toString();
    }