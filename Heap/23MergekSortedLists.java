23. Merge k Sorted Lists

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for (ListNode n : lists){
            if (n != null){
                pq.offer(n);
            }
        }
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            if (cur.next != null){
                pq.offer(cur.next);
            }
            pre.next = cur;
            pre = pre.next;
        }
        return dummy.next;
    }