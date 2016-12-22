345. Reverse Vowels of a String
public String reverseVowels(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        String vowel = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j){
            while (i < j && vowel.indexOf(arr[i]) == -1){
                i++;
            }
            while (i < j && vowel.indexOf(arr[j]) == -1){
                j--;
            }
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return new String(arr);
    }