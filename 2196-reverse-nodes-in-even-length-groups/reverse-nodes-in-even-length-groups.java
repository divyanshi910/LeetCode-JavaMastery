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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        int groupSize = 1; // group sizes start at 1
        
        while (head != null) {
            // Step 1: Count the actual size of this group
            ListNode groupStart = head;
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < groupSize) {
                temp = temp.next;
                count++;
            }
            
            // Step 2: If the group length is even, reverse it
            if (count % 2 == 0) {
                // Reverse 'count' nodes starting from head
                ListNode prev = null;
                ListNode curr = head;
                for (int i = 0; i < count; i++) {
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                // Connect previous group to new head
                prevGroupEnd.next = prev;
                groupStart.next = curr; // groupStart is now the last node
                prevGroupEnd = groupStart;
                head = curr;
            } else {
                // Odd-length group: no reverse
                for (int i = 0; i < count; i++) {
                    prevGroupEnd = head;
                    head = head.next;
                }
            }
            
            groupSize++; // next group is larger
        }
        
        return dummy.next;
    }
}
   