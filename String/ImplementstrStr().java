28. Implement strStr()

public int strStr(String haystack, String needle) {
        int sizeH = haystack.length(), sizeN = needle.length();
        if (sizeH < sizeN){
            return -1;
        }
        for (int i = 0; i <= sizeH - sizeN; i++){
            if (haystack.substring(i, i + sizeN).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    
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