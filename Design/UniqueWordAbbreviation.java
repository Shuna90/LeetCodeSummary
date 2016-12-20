public class ValidWordAbbr {
    HashMap<String, String> map = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++){
            String s = dictionary[i];
            if (s == null || s.length() == 0){
                continue;
            }
            String abb = getAbbr(s);
            if (!map.containsKey(abb)){
                map.put(abb, s);
            }else if (!map.get(abb).equals(s)){
                map.put(abb, "null");
            }
        }
        
    }

    public String getAbbr(String s){
        StringBuilder sb = new StringBuilder();
        int size = s.length();
        if (size <= 2){
            return s;
        }
        sb.append(s.charAt(0));
        sb.append(size - 2);
        sb.append(s.charAt(size - 1));
        return sb.toString();
    }
    public boolean isUnique(String word) {
        String abb = getAbbr(word);
        if (!map.containsKey(abb) || map.get(abb).equals(word)){
            return true;
        }
        return false;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");