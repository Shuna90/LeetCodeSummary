138. Copy List with Random Pointer

/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        while (cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            RandomListNode copyNode = map.get(cur);
            copyNode.next = map.get(cur.next);
            copyNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode cur = head, next;
        while (cur != null){
            RandomListNode copy = new RandomListNode(cur.label);
            next = cur.next;
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            } 
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode pre = new RandomListNode(0);
        RandomListNode copy = pre, copyHead = pre;
        while (cur != null && cur.next != null){
            next = cur.next.next;
            copy = cur.next;
            copyHead.next = copy;
            copyHead = copy;
            cur.next = next;
            cur = next;
        }
        return pre.next;
    }
