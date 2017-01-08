19. Remove Nth Node From End of List

public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode cur = head, pre = first;
        for (int i = 1; i <= n; i++){
            cur = cur.next;
        }
        while (cur != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return first.next;
    }