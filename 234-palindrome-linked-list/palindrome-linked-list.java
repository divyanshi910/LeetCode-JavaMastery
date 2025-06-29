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
public class Solution {
    //brute force  SC: O(N)
    public boolean isPalindromeBrute(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList to ArrayList
        ListNode current = head;
        while (current != null) {
            vals.add(current.val);
            current = current.next;
        }

        // Use two-pointer approach
        int start = 0, end = vals.size() - 1;
        while (start < end) {
            if (!vals.get(start).equals(vals.get(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    //SC: O(1)
     public boolean isPalindrome(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
         ListNode prev=null;
         if(head==null){
            return false;
         }
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            //reverse logic
             ListNode nxt=slow.next;
             slow.next=prev;
             prev=slow;
             slow=nxt;
        }
        //in case of odd list,move the slow pointer by 1 step
        if(fast!=null){
            slow=slow.next;
        }
        //compare both list
        while(slow!=null){
            if(slow.val!=prev.val){
                return false;
            }
            slow=slow.next;
            prev=prev.next;
        }
        return true;
     }
}
