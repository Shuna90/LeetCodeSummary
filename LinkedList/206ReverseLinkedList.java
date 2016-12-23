206. Reverse Linked List
public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null){
            ListNode nextN = node.next;
            node.next = pre;
            pre = node;
            node = nextN;
        }
        return pre;
    }