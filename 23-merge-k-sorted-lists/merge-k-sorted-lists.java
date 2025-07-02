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
    public ListNode merge2Lists(ListNode list1,ListNode list2){
        ListNode dummy =  new ListNode(0);
        ListNode temp = dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                 temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1==null ? list2 : list1;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode result = lists[0];
        for(int i=1;i<lists.length;i++){
           result = merge2Lists(result , lists[i]);
        }
        return result;
    }
}