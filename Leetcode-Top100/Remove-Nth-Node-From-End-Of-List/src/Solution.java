
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/16 15:16
 *
 * @author crwen
 * @create 2020-03-16-15:16
 * @since JDK 1.8
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count ++;
        }
        if (count < n)
            return head;
        if (count == n)
            return head.next;

        ListNode pre = head;
        cur = head;
        for (int i = 0; i < count; i++) {
            if (i > n) {
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = pre.next.next;

        return head;
    }
}
