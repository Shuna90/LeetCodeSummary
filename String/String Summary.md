String Summary

String
s.split(regex);	
	regex:
		\\	The backslash character
		[abc]	a, b, or c (simple class)
		[^abc]	Any character except a, b, or c (negation)
		[a-zA-Z]	a through z or A through Z, inclusive (range)
		[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
		X*	X, zero or more times
		X+	X, one or more times
		X{n}	X, exactly n times
		X{n,m}	X, at least n but not more than m times
		s.split(" +"); // split based on one or more blankspace
	String s = /...
	String[] arr = s.split("/+");
	arr[0] = "";
	arr[1] = "..."
	s = " "
	String[] arr = s.split(" +");
	arr[0] = ""
	arr.length == 0 =======> no "/" in s

	if just a dot .
	split("\\.")
	
s.trim();
s.substring(include, exclude);
s.lastIndexOf("/") 	// pay attetion to -1 

StringBuilder
StringBuilder sb = new StringBuilder();
sb.insert(index, .....);
sb.deleteCharAt()
sb.delete(inclusive, exclusive)
sb.lastIndexOf("/") 	// pay attetion to -1 

int to String: 	//int + "", will be slow
				Integer.toString(int i)
				String.valueOf(int i)
String to int: 	Integer.parseInt(s)
int to char:	char b = (char)(a + '0');
char to int:	int x= str1.charAt(2)-'0';
char[] to String:	String.valueOf(char[])
					String newString1 = new String(charArrays);

s1: String
s2: Integer
s1.campareTo(s2):	s1 > s2 return > 0	

String 
s1 + s2
s2 + s1

substring template
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



