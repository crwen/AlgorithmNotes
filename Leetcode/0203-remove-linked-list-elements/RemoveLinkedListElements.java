//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 475 👎 0


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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode dummdyHead = new ListNode(-1);
        dummdyHead.next = head;
        ListNode cur = dummdyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummdyHead.next;
    }

    // 递归
    //public ListNode removeElements(ListNode head, int val) {
    //    if (head == null)
    //        return head;
    //    if (head.val == val) {
    //        return removeElements(head.next, val);
    //    } else {
    //        head.next = removeElements(head.next, val);
    //        return head;
    //    }
    //}
}
//leetcode submit region end(Prohibit modification and deletion)
