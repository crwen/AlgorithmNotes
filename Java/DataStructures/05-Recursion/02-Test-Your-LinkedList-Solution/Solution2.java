
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

	public static void main(String[] args) {

		int[] nums = {1, 2, 6, 3, 4, 5, 6};
		ListNode head = new ListNode(nums);
		System.out.println(head);

		ListNode res = (new Solution3()).removeElements(head, 6);
		System.out.println(res);
	}

}