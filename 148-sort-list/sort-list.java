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
    public ListNode sortList(ListNode head) {
       return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowD = null;
        while(fast!=null && fast.next!=null){
            slowD = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowD.next = null;//it is the first list last node
        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(slow); //it is the second list first node
        ListNode ans = merge(head1 , head2);
        return ans;
    }
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while(head1!=null && head2!=null){
        if(head1.val<head2.val){
            temp.next = head1;
            head1 = head1.next;
        }
        else{
             temp.next = head2;
            head2 = head2.next;
        }
        temp = temp.next;
        }
       temp.next= head1==null ? head2 : head1;
       return tempHead.next;
    }
}