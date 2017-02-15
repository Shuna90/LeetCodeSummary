394. Decode String

/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> count = new Stack<Integer>();
        Stack<StringBuilder> res = new Stack<StringBuilder>();
        int num = 0;
        for (char c : s.toCharArray()){
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if (c == '['){
                count.push(num);
                res.push(sb);
                num = 0;
                sb = new StringBuilder();
            }else if (c == ']'){
                StringBuilder tmp = sb;
                StringBuilder cur = res.pop();
                for (int i = count.pop(); i > 0; i--){
                    cur.append(tmp);
                }
                sb = cur;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }