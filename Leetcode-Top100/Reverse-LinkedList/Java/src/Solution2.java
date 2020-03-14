
/**
 * ClassName: Solution2
 * Description:
 * date: 2020/3/14 22:13
 *
 * @author crwen
 * @create 2020-03-14-22:13
 * @since JDK 1.8
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
