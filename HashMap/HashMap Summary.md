HashMap Summary

HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
map.put();
map.getOrDefault();
map.get();
for (Integer i : map.values()){}
may be slow if needed, use list to store the distinct integer and iterator through list

map.entrySet()
Map.Entry() a;
a.getKey();
a.getValue();

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


check duplicate

check buckets
	HashMap<bucket, value> map
	bucket: arr[i] - minvalue / bucket size
	check: 	in same bucket ---> duplicated
			adjacent buckets, map.get(bucket - 1), map.get(bucket + 1)
	size:	size >= k remove first bucket
	map.put(bucket, value)

add up to specific target