6. ZigZag Conversion
public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 1){
            return s;
        }
        char[] arr = s.toCharArray();
        int size = arr.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int index = 0;
        while (index < size){
            for (int i = 0; i < numRows && index < size; i++){
                sb[i].append(arr[index++]);
            }
            for (int i = numRows - 2; i >= 1 && index < size; i--){
                sb[i].append(arr[index++]);
            }
        }
        for (int i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }