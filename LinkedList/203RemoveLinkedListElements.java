203. Remove Linked List Elements

public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode cur = head, pre = first;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return first.next;
    }

public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }