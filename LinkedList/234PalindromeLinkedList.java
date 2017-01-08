234. Palindrome Linked List
public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        while (slow != null){
            if (head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }