public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        if (s == null || s.length() == 0 || s.length() > 12){
            return res;
        }
        ip(s, 0, res, 0, "");
        return res;
    }
    public void ip(String s, int index, List<String> res, int cut, String newString){
        if (cut == 3){
            String tmp = s.substring(index, s.length());
            if (valid(tmp)){
                res.add(new String(newString + tmp));
            }
            return;
        }
        for (int i = index + 1; i <= index + 3 && i < s.length(); i++){
            String tmp = s.substring(index, i);
            if (valid(tmp)){
                ip(s, i, res, cut + 1, newString + tmp + ".");
            }
        }
    }
    public boolean valid(String s){
        if (s == null || s.length() == 0){
            return false;
        }
        if (s.charAt(0) == '0'){
            return s.equals("0");
        }
        long l = Long.parseLong(s);
        if (l >= 0 && l <= 255){
            return true;
        }else{
            return false;
        }
    }
}