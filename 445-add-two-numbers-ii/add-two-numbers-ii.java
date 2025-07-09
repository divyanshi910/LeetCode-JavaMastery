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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head = null;
     
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0 ;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry!=0){
            int val1 = (stack1.isEmpty())?0:stack1.pop();
            int val2 = (stack2.isEmpty())?0:stack2.pop();
            int value = val1 + val2 + carry;
            ListNode newNode = new ListNode(value%10);
            carry = value/10;
           // Insert at head (since we're building the result from end to start)
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}