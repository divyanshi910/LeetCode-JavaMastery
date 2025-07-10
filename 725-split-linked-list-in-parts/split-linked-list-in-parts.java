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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int length=count/k;
        int extra=count%k;
        temp = head;
        ListNode res[] = new ListNode[k];
        for(int i=0;i<k;i++){
            if(temp==null){
                break;
            }
            ListNode prev = null;
            ListNode currHead=temp;
            int len = 0;
            while(temp!=null && len<length){
                prev = temp;
                temp = temp.next;
                len++;
            }
                if(extra>0){
                    prev = temp;
                    temp = temp.next;
                    extra--;
                }
                //detach linked list now
                prev.next = null;
                res[i] = currHead;//insert heads in array
            }
    
     return res;
}
}