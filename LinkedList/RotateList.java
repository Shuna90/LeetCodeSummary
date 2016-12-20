/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int size = 0;
        ListNode now = head;
        while (now != null){
            size++;
            now = now.next;
        }
        k = k % size;
        if (k == 0){
            return head;
        }
        ListNode head2 = head;
        while (k > 0){
            k--;
            head2 = head2.next;
        }
        now = head;
        while (head2.next != null){
            head2 = head2.next;
            now = now.next;
        }
        ListNode dummy = now.next;
        now.next = null;
        head2.next = head;
        return dummy;
    }
}