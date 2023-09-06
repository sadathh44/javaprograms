package linked_list;

class Solution {
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode first = reverse(mid);
        ListNode second = head;
        while(first != null && second != null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
