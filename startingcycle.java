package linked_list;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solutio n {
    public ListNode detectCycle(ListNode head) {
        
        ListNode t=head;
        
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            
            if(slow==fast)
            {
                while(t!=slow)
                {
                    t=t.next;
                    slow=slow.next;
                }
                return t;
            }
            
        }
        
        return null;
    }
}