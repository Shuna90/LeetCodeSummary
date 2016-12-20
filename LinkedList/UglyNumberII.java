public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0){
            return 0;
        }
        Node cur = new Node(1);
        Node n2 = cur;
        Node n3 = cur;
        Node n5 = cur;
        for (int i = 2; i <= n; i++){
            int min = Math.min(n2.val * 2, Math.min(n3.val * 3, n5.val * 5));
            cur.next = new Node(min);
            cur = cur.next;
            n2 = n2.val * 2 == min ? n2.next : n2;
            n3 = n3.val * 3 == min ? n3.next : n3;
            n5 = n5.val * 5 == min ? n5.next : n5;
        }
        return cur.val;
    }
    public class Node{
        int val;
        Node next;
        public Node(int a){
            val = a;
        }
    }
}