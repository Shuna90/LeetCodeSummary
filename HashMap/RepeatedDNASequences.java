public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() <= 10){
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - 10; i++){
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub)){
                map.put(sub, 1);
            }else{
                map.put(sub, map.get(sub) + 1);
                if (map.get(sub) == 2){
                    res.add(sub);
                }
            }
        }
        return res;
    }
}