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
    public ListNode reverseKGroup(ListNode head, int k) {
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
}