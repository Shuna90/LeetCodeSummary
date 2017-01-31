451. Sort Characters By Frequency
/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
*/

public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>(){
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
                    return b.getValue() - a.getValue();
                }
        });
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry e = pq.poll();
            int value = (int)e.getValue();
            char c = (char)e.getKey();
            for (int i = 0; i < value; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }


public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] arr = new List[s.length() + 1];
        for (char key : map.keySet()){
            int value = map.get(key);
            if (arr[value] == null){
                arr[value] = new ArrayList<>();
            }
            arr[value].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i > 0; i--){
            if (arr[i] != null){
                for (char key : arr[i]){
                    int value = map.get(key);
                    for (int j = 0; j < value; j++){
                        sb.append(key);
                    }
                }
            }
        }
        return sb.toString();
    }

