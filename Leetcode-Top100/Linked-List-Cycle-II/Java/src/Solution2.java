
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/22 0:55
 *
 * @author crwen
 * @create 2020-03-22-0:55
 * @since JDK 1.8
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return  null;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
