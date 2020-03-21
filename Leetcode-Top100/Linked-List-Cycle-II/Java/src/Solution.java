
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/22 0:54
 *
 * @author crwen
 * @create 2020-03-22-0:54
 * @since JDK 1.8
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return  null;
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
