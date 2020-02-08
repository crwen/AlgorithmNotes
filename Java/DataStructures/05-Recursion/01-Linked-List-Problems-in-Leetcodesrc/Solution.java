/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode removeElements(ListNode head, int val) {

	    while (head != null && head.val == val) {
            ListNode node = head;
            head = head.next;
            node.next = null;
        }
	    if (head == null)
	        return null;

	    ListNode pre = head;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else  {
                pre = pre.next;
            }
        }
        return head;
	}

	public void remove() {

    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}