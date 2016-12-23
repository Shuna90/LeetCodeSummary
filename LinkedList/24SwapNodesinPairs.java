24. Swap Nodes in Pairs

public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode n = head.next;
        ListNode newNode = swapPairs(head.next.next);
        head.next = newNode;
        n.next = head;
        return n;
    }