383. Ransom Note
public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()){
            int result = map.getOrDefault(c, 0) - 1;
            if (result < 0){
                return false;
            }
            map.put(c, result);
        }
        return true;
    }