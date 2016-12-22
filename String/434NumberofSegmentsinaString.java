434. Number of Segments in a String
public int countSegments(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] arr = s.trim().toCharArray();
        int j = 0, count = 0;
        while (j < arr.length){
            while (j < arr.length && arr[j] != ' '){
                j++;
            }
            count++;
            while (j < arr.length && arr[j] == ' '){
                j++;
            }
        }
        return count;
    }

public int countSegments(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')){
                res++;
            }
        }
        return res;
    }