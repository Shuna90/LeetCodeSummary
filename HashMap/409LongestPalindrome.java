409. Longest Palindrome
 public int longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> map = new HashSet<Character>();
        int size = s.length();
        int count = 0;
        for (int i = 0; i < size; i++){
            if (map.contains(s.charAt(i))){
                map.remove(s.charAt(i));
                count++;
            }else{
                map.add(s.charAt(i));
            }
        }
        return map.isEmpty() ? count * 2 : count * 2 + 1;
    }