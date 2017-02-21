344. Reverse String

/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

public String reverseString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }

// divid & conquer:
public String reverseString(String s) {
        int size = s.length();
        if (size <= 1){
            return s;
        }
        String left = s.substring(0, size / 2);
        String right = s.substring(size / 2, size);
        return reverseString(right) + reverseString(left);
    }

public String reverseString(String s) {
	return new StringBuilder(s).reverse().toString();
}