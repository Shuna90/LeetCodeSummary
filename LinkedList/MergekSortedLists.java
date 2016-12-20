/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        return mergeSort(lists, 0, lists.length - 1);
    }
    public ListNode mergeSort(ListNode[] lists, int low, int high){
        if (low >= high){
            return lists[low];
        }
        int mid = low + (high - low) / 2;
        ListNode l = mergeSort(lists, low, mid);
        ListNode h = mergeSort(lists, mid + 1, high);
        return merge(l, h);
    }
    public ListNode merge(ListNode l, ListNode h){
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        while (l != null && h != null){
            if (l.val <= h.val){
                cur.next = l;
                l = l.next;
            }else{
                cur.next = h;
                h = h.next;
            }
            cur = cur.next;
        }
        if (l != null){
            cur.next = l;
        }else{
            cur.next = h;
        }
        return pre.next;
    }
}