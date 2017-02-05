445. Add Two Numbers II

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null){
            map1.put(i++, cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            map2.put(j++, cur2.val);
            cur2 = cur2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (i > 0 || j > 0 || carry > 0){
            int a = i-- > 0 ? map1.get(i) : 0;
            int b = j-- > 0 ? map2.get(j) : 0;
            int res = a + b + carry;
            ListNode newNode = new ListNode(res % 10);
            carry = res / 10;
            newNode.next = head;
            head = newNode;
        }
        return head;
    }


public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        // Make sure l1.length >= l2.length
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        // Handle the first digit
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }
    // get length of the list
    public int getLength(ListNode l) {
        int count = 0;
        while(l != null) {
            l = l.next;
            count++;
        }
        return count;
    }
    // offset is the difference of length between l1 and l2
    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) return null;
        // check whether l1 becomes the same length as l2
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        // handle carry 
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        // combine nodes
        result.next = post;
        return result;
    }
