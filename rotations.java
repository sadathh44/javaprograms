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
    public ListNode rotateRight(ListNode head, int k) {
    if(head==null || head.next==null || k<=0)
    {
      return head;  
    }
    int length=1;
    ListNode temp=head;
    while(temp.next!=null)
    {
        temp=temp.next;
        length++;
    }
    temp.next=head;
    int rotations=k%length;
    int key=length-rotations;
    ListNode newlast=head;
    for(int i=0;i<key-1;i++)
    {
        newlast=newlast.next;
    }
    head=newlast.next;
    newlast.next=null;
    
    return head;
    }
}