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
    //TC O(n) SC O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;
        if(head==null){
            return null;
        }
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int length=count-n;
        if(length==0){
            return head.next; //if length is only one
        }
        temp=head;
        for(int i=0;i<length-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}