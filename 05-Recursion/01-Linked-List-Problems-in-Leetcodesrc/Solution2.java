
class Solution2 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;

		ListNode header = new ListNode(-1);
		header.next = head;

	    ListNode pre = header;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else  {
                pre = pre.next;
            }
        }
        return header.next;
	}


	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}