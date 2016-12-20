/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode now = dummy;
        ListNode pre = dummy;
        int carry = 0;
        while (l1 != null || l2 != null){
           int sum = carry;
           if (l1 != null){
               sum += l1.val;
               l1 = l1.next;
           }
           if (l2 != null){
               sum += l2.val;
               l2 = l2.next;
           }
            carry = sum / 10;
            sum = sum % 10;
           now.next = new ListNode(sum);
           now = now.next;
        }
        if (carry != 0){
            now.next = new ListNode(carry);
        }
        return pre.next;
    }
}