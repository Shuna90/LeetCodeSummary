389. Find the Difference
public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            if (--arr[t.charAt(i) - 'a'] < 0){
                return t.charAt(i);
            }
        }
        return 0;
    }

// not letter using hashmap

public char findTheDifference(String s, String t) {
        char bit = 0;
        for (int i = 0; i < s.length(); i++){
            bit ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++){
            bit ^= t.charAt(i);
        }
        return bit;
    } 