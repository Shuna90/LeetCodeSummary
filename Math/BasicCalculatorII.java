public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        List<Integer> value = new ArrayList<Integer>();
        List<Character> operation = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }else if (c == '+' || c == '-' || c == '*' || c == '/'){
                operation.add(c);
            }else {
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                i--;
                value.add(Integer.parseInt(sb.toString()));
                if (operation.isEmpty()){
                    continue;
                }
                if (operation.get(operation.size() - 1) == '/' || operation.get(operation.size() - 1) == '*'){
                    int v2 = value.remove(value.size() - 1);
                    int o = operation.remove(operation.size() - 1);
                    int v1 = value.remove(value.size() - 1);
                    if (o == '*'){
                        value.add(v1 * v2);
                    }else{
                        value.add(v1 / v2);
                    }
                }
            }
        }
        Iterator<Integer> iterI = value.iterator();
        Iterator<Character> iterO = operation.iterator();
        int res = iterI.next();
        while (iterO.hasNext()){
            int v = iterI.next();
            char c = iterO.next();
            if (c == '+'){
                res += v;
            }else{
                res -= v;
            }
        }
        return res;
    }
}