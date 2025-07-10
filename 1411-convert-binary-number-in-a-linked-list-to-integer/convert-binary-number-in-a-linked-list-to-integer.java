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
    public int getDecimalValue2(ListNode head) {
        ListNode temp = head;
        int count =0;
           while(temp!=null){
            count++;
            temp = temp.next;
        }
        int res=0;
        while(head!=null){
            count--;
            res +=  head.val * Math.pow(2,count);
            head = head.next;
        }
        return res;
    }
    public int getDecimalValue(ListNode head) {
         int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }
}