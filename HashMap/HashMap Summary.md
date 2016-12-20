HashMap Summary

HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
map.put();
map.get();
for (Integer i : map.values()){}
may be slow if needed, use list to store the distinct integer and iterator through list

map.entrySet()

check duplicate

check buckets
	HashMap<bucket, value> map
	bucket: arr[i] - minvalue / bucket size
	check: 	in same bucket ---> duplicated
			adjacent buckets, map.get(bucket - 1), map.get(bucket + 1)
	size:	size >= k remove first bucket
	map.put(bucket, value)

add up to specific target