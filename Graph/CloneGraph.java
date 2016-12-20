/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!q.isEmpty()){
            UndirectedGraphNode tmp = q.poll();
            UndirectedGraphNode copy = map.get(tmp);
            for (UndirectedGraphNode n : tmp.neighbors){
                if (!map.containsKey(n)){
                    map.put(n, new UndirectedGraphNode(n.label));
                    q.offer(n);
                }
                copy.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}