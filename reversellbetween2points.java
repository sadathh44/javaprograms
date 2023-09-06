package linked_list;
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
    public ListNode reverseBetween(ListNode head, int left, int right) {    ListNode current=head;
    ListNode prev=null;
    int count=1;
         for(int i=0;current!=null && i<left-1;i++)
         {
             prev=current;
             current=current.next;
         }
         ListNode last=prev;
         ListNode newend=current;
         ListNode next=current.next;
         for(int j=0;current!=null && j<right-left+1;j++)
         {
             current.next=prev;
             prev=current;
             current=next;
             if(next!=null)
             {
                 next=next.next;
             }
         }
         if(last!=null)
         {
             last.next=prev;
         }
         else
         {
             head=prev;
         }
         newend.next=current;
        return head;
        
    }
}