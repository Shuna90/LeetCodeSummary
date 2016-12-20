public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new LinkedList<String>();
        List<String> solution = new LinkedList<String>();
        boolean[] check = new boolean[s.length() + 1];
        check[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (check[j] && wordDict.contains(s.substring(j,i))){
                    check[i] = true;
                    break;
                }
            }
        }
        if (!check[s.length()]){
            return res;
        }
        helper(s, wordDict, 0, res, solution);
        return res;
    }
    public void helper(String s, Set<String> wordDict, int index, List<String> res, List<String> solution){
        if (index == s.length()){
            StringBuilder sb = new StringBuilder();
            for (String tmp : solution){
                sb.append(tmp);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if (wordDict.contains(sub)){
                solution.add(sub);
                helper(s, wordDict, i, res, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }
}