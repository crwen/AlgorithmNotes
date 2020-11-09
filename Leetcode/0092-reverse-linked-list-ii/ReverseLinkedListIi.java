//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 572 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;
        ListNode dummdyHead = new ListNode(-1);
        dummdyHead.next = head;
        ListNode tail1 = dummdyHead;
        ListNode cur = head;
        int i = 1;
        for (i = 1; i < m && cur != null; i++) {
            tail1 = tail1.next;
            cur = cur.next;
        }
        ListNode cutHead = tail1.next;
        tail1.next = null;
        ListNode pre = null;
        for (; i <= n && cur != null; i ++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tail1.next = pre;
        cutHead.next = cur;

        return dummdyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
