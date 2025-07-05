/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next==null || head.next.next==null){
            return ;
        }
        //find middle
        //then reverse second half
        //insert second half reverse one to first half
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        //detach the two linked list
        slow.next = null;
        //reverse the second ll
        ListNode curr = secondHead;
        ListNode prev = null;
        while(curr!=null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        //insert the two ll now
        ListNode t1 = head;
        ListNode t2 = prev; //as this is the head of second LL
        while(t2!=null){
            ListNode m1 = t1.next;
            ListNode m2 = t2.next; //as they will get broke if we dont save it
            t1.next = t2;
            t2.next = m1;
            t1 = m1 ;
            t2 = m2;
        }
    }
}