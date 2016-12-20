public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.length == 0){
            return res;
        }
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        for (int i = 0; i < tickets.length; i++){
            if (!graph.containsKey(tickets[i][0])){
                graph.put(tickets[i][0], new ArrayList<String>());
            }
            graph.get(tickets[i][0]).add(tickets[i][1]);
        }
        for (List<String> list : graph.values()){
            Collections.sort(list);
        }
        res.add("JFK");
        find(res, graph, "JFK", tickets.length + 1);
        return res;
    }
    public boolean find(List<String> res, HashMap<String, List<String>> graph, String s, int n){
        if (res.size() == n){
            return true;
        }
        if (!graph.containsKey(s) || graph.get(s).isEmpty()){
            return false;
        }
        List<String> list = graph.get(s);
        for (int i = 0; i < list.size(); i++){
            String next = list.get(i);
            res.add(next);
            list.remove(i);
            if (find(res, graph, next, n)){
                return true;
            }
            res.remove(res.size() - 1);
            list.add(i, next);
        }
        return false;
    }
}