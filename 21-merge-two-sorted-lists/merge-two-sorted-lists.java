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
    public ListNode mergeTwoListsI(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head=null;
        if(list1.val<list2.val){
            head=list1;
            list1=list1.next;
        }
        else{
            head=list2;
            list2=list2.next;
        }
        ListNode temp=head;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //if 1 list gets finished then attach head with the remaining list
        temp.next = list1==null ? list2 : list1;
        return head;
    }
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
         while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //if 1 list gets finished then attach head with the remaining list
        temp.next = list1==null ? list2 : list1;
        return dummy.next;
     }
}