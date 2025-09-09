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
    ListNode reverseList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    //SC O(N)
    public ListNode removeNodesStack(ListNode head) {
       head= reverseList(head);
        Stack<ListNode>stack=new Stack<>();
        ListNode temp=head;
        int value=Integer.MIN_VALUE;
        while(temp!=null){
            if(temp.val>=value){
                stack.push(temp);
                value=temp.val;
            }
            temp=temp.next;
        }
        ListNode dummy=new ListNode(0);
        ListNode c=dummy;
        while(!stack.isEmpty()){
            c.next=stack.pop();
            c=c.next;
        }
        c.next=null;
        return dummy.next;
    }
    //Sc O(1)
     public ListNode removeNodes(ListNode head) {
     // Step 1: Reverse the list
        head = reverseList(head);

        // Step 2: Remove nodes that are smaller than max seen so far
        ListNode curr = head;
        int maxVal = curr.val;
        ListNode prev = curr;
        curr = curr.next;

        while (curr != null) {
            if (curr.val >= maxVal) {
                maxVal = curr.val;
                prev = curr; // keep this node
            } else {
                // skip the node
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        // Step 3: Reverse back to original order
        return reverseList(head);
    }
}