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
    public int len(ListNode head){
        int counter=0;
        while(head!=null){
            head=head.next;
            counter++;
        }
        return counter;
    }
    public ListNode reverseKGroupItera(ListNode head, int k) {
        int N=len(head);
        int groups = N/k;
        ListNode prevHead=null;
        ListNode currHead=head;
        ListNode ansNode=null;
        for(int i=0;i<groups;i++){
            ListNode prev=null;
            ListNode nxt=null;
            ListNode curr=currHead;
            //reverse k elements
            for(int j=0;j<k;j++){
                nxt = curr.next;
                curr.next=prev;
                prev=curr;
                curr=nxt;
            }
            if(prevHead==null){
                ansNode = prev;
            }
            else{
                prevHead.next=prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        // link the last complete group
        prevHead.next = currHead;
        return ansNode;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: Check if there are at least k nodes left
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        if (count < k) {
            return head; // Not enough nodes to reverse
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        curr = head;
        ListNode next = null;
        count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursively reverse next part of list
        if (next != null) {
            head.next = reverseKGroup(next, k); // head is now the tail of the reversed part
        }

        return prev; // prev is the new head after reversal
    }

}