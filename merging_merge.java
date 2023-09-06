package linked_list;
class Solution {
    public  ListNode merge(ListNode left, ListNode right) {
        ListNode temp1 = left;
        ListNode temp2 = right;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                ans.next = temp1;
                ans = ans.next;
                temp1 = temp1.next;
            } else {
                ans.next = temp2;
                ans = ans.next;
                temp2 = temp2.next;
            }
        }
        ans.next = (temp1 != null) ? temp1 : temp2;
        return dummy.next;
    }
	public static ListNode mid(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
     	ListNode mid = mid(head);
		ListNode left = head;
		ListNode right = mid.next;
		mid.next = null;
		
		left = sortList(left);
		right = sortList(right);
		
		ListNode result = merge(left, right);
		return result;
    }
}