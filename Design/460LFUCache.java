460. LFU Cache
/*
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

public class Node{
        public int count = 0;
        public LinkedHashSet<Integer> keys = null;
        public Node pre, next;
        
        public Node(Node pre, Node next, int count, int key){
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            keys.add(key);
            this.pre = pre;
            this.next = next;
        }
    }
    
    private Node head;
    private int cap;
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Node> nodeMap;
    
    public LFUCache(int capacity) {
        cap = capacity;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
        head = null;
    }
    
    public int get(int key) {
        if (valueMap.containsKey(key)){
            increase(key);
        }
        return valueMap.getOrDefault(key, -1);
    }
    
    public void increase(int key){
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null){
            node.next = new Node(node, null, node.count + 1, key);
        }else if (node.next.count == node.count + 1){
            node.next.keys.add(key);
        }else{
            Node nextNode = new Node(node, node.next, node.count + 1, key);
            node.next = nextNode;
            nextNode.pre = nextNode;
        }
        nodeMap.put(key, node.next);
        if (node.keys.isEmpty()){
            removeNode(node);
        }
    }
    
    public void removeNode(Node node){
        if (head == node){
            head = node.next;
        }else{
            node.pre.next = node.next;
        }
        if (node.next != null){
            node.next.pre = node.pre;
        }
    }
    
    public void put(int key, int value) {
        if (cap == 0){
            return;
        }
        if (valueMap.containsKey(key)){
            valueMap.put(key, value);
            increase(key);
        }else{
            if (valueMap.size() == cap){
                removeLeast();
            }
            valueMap.put(key, value);
            add(key);
        }
    }
    
    public void removeLeast(){
        if (head == null){
            return;
        }
        int oldest = head.keys.iterator().next();
        head.keys.remove(oldest);
        if (head.keys.isEmpty()){
            removeNode(head);
        }
        nodeMap.remove(oldest);
        valueMap.remove(oldest);
    }
    
    public void add(int key){
        if (head == null){
            head = new Node(null, null, 1, key);
        }else if (head.count == 1){
            head.keys.add(key);
        }else{
            head.pre = new Node(null, head, 1, key);
            head = head.pre;
        }
        nodeMap.put(key, head);
    }