/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        ListNode node = dummy;
        ListNode mid = mid(head);
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        while (head != null && head2 != null){
            node.next = head;
            head = head.next;
            node = node.next;
            node.next = head2;
            head2 = head2.next;
            node = node.next;
        }
        if (head2 != null){
            node.next = head2;
        }
        head = dummy.next;
    }
    public ListNode mid(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode now = node;
        while (now != null){
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}