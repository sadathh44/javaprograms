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
    public ListNode reverseList(ListNode head) {
     if(head==null)
    {
      return head;  
    }
    ListNode prev=null;
    ListNode present=head;
    while(present!=null)
    {
    ListNode nexts=present.next;
        present.next=prev;
        prev=present;
        present=nexts;
    }
    return prev;
    }
}