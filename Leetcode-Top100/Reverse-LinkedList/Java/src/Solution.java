
/**
 * ClassName: Solution
 * Description:
 * date: 2020/3/14 22:04
 *
 * @author crwen
 * @create 2020-03-14-22:04
 * @since JDK 1.8
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    // pre-->cur-->next--> ...
    //pre<--cur   next--> ...
    // --->pre(cur)   next--> ...
    // --->pre cur(next)--> ...
    // --->pre cur-->next-->...

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
