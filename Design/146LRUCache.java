
146. LRU Cache
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity *//* );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

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