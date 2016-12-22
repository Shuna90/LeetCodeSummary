83. Remove Duplicates from Sorted List

public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        ListNode node = cur.next;
        while (node != null){
            while (node != null && node.val == cur.val){
                node = node.next;
            }
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }