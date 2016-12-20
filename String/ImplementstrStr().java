public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null){
            return 0;
        }
        int hsize = haystack.length();
        int nsize = needle.length();
        if (nsize > hsize){
            return -1;
        }
        for (int i = 0; i <= hsize - nsize; i++){
            int j = 0;
            for (; j < nsize && haystack.charAt(j + i) == needle.charAt(j); j++){}
            if (j == nsize){
                return i;
            }
        }
        return -1;
    }
}