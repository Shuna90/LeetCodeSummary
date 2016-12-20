import java.util.LinkedHashMap;
public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true){
            public boolean removeEldestEntry(Map.Entry eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void set(int key, int value) {
        map.put(key,value);
    }
}


public class LRUCache {
    HashMap<Integer, Node> map;
    Node pre;
    Node next;
    int size = 0;
    int count = 0;
    public class Node{
        int val;
        int key;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        size = capacity;
        pre = new Node(-1, 0);
        next = new Node(-1, 0);
        pre.pre = null;
        pre.next = next;
        next.pre = pre;
        next.next = null;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node cur = map.get(key);
            deleteNode(cur);
            addNode(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            deleteNode(cur);
            addNode(cur);
        }else{
            Node cur = new Node(key, value);
            map.put(key, cur);
            addNode(cur);
            count++;
            if (count > size){
                int dv = pre.next.key;
                deleteNode(pre.next);
                count--;
                map.remove(dv);
            }
        }
    }
    public void addNode(Node cur){
        cur.pre = next.pre;
        cur.pre.next = cur;
        cur.next = next;
        next.pre = cur;
    }
    public void deleteNode(Node cur){
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;
    }
}