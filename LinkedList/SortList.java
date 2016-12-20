/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = partition(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode n1, ListNode n2){
        if (n1 == null && n2 == null){
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode pre = node;
        while (n1 != null && n2 != null){
            if (n1.val <= n2.val){
                node.next = n1;
                n1 = n1.next;
            }else{
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 != null){
            node.next = n1;
        }
        if (n2 != null){
            node.next = n2;
        }
        return pre.next;
    }
    public ListNode partition(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode slow = dummy;
        ListNode fast = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}