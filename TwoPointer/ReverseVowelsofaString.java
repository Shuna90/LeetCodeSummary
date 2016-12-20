public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while (low < high){
            while (low < high && !set.contains(Character.toLowerCase(arr[low]))){
                low++;
            }
            while (low < high && !set.contains(Character.toLowerCase(arr[high]))){
                high--;
            }
            if (low < high){
                char tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
            low++;
            high--;
        }
        return new String(arr);
    }
}