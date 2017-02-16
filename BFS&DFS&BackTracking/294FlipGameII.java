294. Flip Game II

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/

public boolean canWin(String s) {
        if (s == null || s.length() <= 1){
            return false;
        }
        char[] c = s.toCharArray();
        return helper(c);
    }
    public boolean helper(char[] c){
        for (int i = 0; i < c.length - 1; i++){
            if (c[i] == '+' && c[i + 1] == '+'){
                c[i] = '-';
                c[i + 1] = '-';
                boolean flag = !helper(c);
                c[i] = '+';
                c[i + 1] = '+';
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

public boolean canWin(String s) {
        if (s == null || s.length() <= 1){
            return false;
        }
        HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
        return helper(s, winMap);
    }
    public boolean helper(String s, HashMap<String, Boolean> winMap){
        if (winMap.containsKey(s)){
            return winMap.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++){
            if (s.startsWith("++", i)){
                String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(tmp, winMap)){
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }