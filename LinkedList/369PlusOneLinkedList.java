369. Plus One Linked List
/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
*/
public ListNode plusOne(ListNode head) {
        if (head == null){
            return new ListNode(1);
        }
        ListNode newNext = plusOne(head.next);
        if (newNext != head.next){
            head.val++;
        }
        if (head.val <= 9){
            return head;
        }
        head.val = 0;
        newNext.next = head;
        return newNext;
    }