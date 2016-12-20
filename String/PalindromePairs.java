public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (words == null || words.length == 0){
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            for (int j = 0; j <= s.length(); j++){
                String pre = s.substring(0, j);
                String aft = s.substring(j);
                if (isPalindrome(pre) && map.containsKey(reverse(aft)) && map.get(reverse(aft)) != i){
                    addList(map.get(reverse(aft)), i, set);
                }
                if (isPalindrome(aft) && map.containsKey(reverse(pre)) && map.get(reverse(pre)) != i){
                    addList(i, map.get(reverse(pre)), set);
                }
            }
        }
        for (List<Integer> list : set){
            res.add(list);
        }
        return res;
    }
    public boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public void addList(int i, int j, Set<List<Integer>> res){
        List<Integer> list = new LinkedList<Integer>();
        list.add(i);
        list.add(j);
        res.add(list);
    }
}