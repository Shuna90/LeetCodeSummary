242. Valid Anagram
public boolean isAnagram(String s, String t) {
        if (s == null || s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            arr[index]++;
        }
        for (int i = 0; i < t.length(); i++){
            int index = t.charAt(i) - 'a';
            arr[index]--;
            if (arr[index] < 0){
                return false;
            }
        }
        return true;
    }

public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }