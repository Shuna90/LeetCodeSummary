public class WordDistance {
    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    int size;
    public WordDistance(String[] words) {
        size = words.length;
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            if (!map.containsKey(s)){
                map.put(s, new ArrayList<Integer>());
            }
            map.get(s).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> arr1 = map.get(word1);
        List<Integer> arr2 = map.get(word2);
        int min = size;
        for (int i = 0, j = 0; i < arr1.size() && j < arr2.size();){
            int index1 = arr1.get(i);
            int index2 = arr2.get(j);
            if (index1 < index2){
                min = Math.min(min, index2 - index1);
                i++;
            }else{
                min = Math.min(min, index1 - index2);
                j++;
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");