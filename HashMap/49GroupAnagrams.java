49. Group Anagrams

/* 
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if (!map.containsKey(s)){
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
