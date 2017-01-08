438. Find All Anagrams in a String

template for Sliding Window Solution
int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }


public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        if (s == null || s.length() < p.length()){
            return res;
        }
        int[] arr = new int[256];
        for (char c : p.toCharArray()){
            arr[c]++;
        }
        
        int left = 0, right = 0, count = p.length();
        while (right < s.length()){
            if (arr[s.charAt(right++)]-- > 0){
                count--;
            }
            if (count == 0){
                res.add(left);
            }
            if (right - left == p.length() && arr[s.charAt(left++)]++ >= 0){
                count++;
            }
        }
        return res;
    }